/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.BenhNhan;
import entities.NhanVien;
import entities.Thuoc;
import entities.ToaThuoc;
import entities.ToaThuocChiTiet;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.NhanVienInfo;
import models.PatientInfo;
import models.ToaInfo;
import sessionbeans.BenhNhanFacade;
import sessionbeans.NhanVienFacade;
import sessionbeans.ThuocFacade;
import sessionbeans.ToaThuocChiTietFacade;
import sessionbeans.ToaThuocFacade;
import utils.Config;

/**
 *
 * @author huytd
 */
@WebServlet(name = "MProcessController", urlPatterns = {"/mprocess"})
public class MProcessController extends HttpServlet {

    @EJB
    private ToaThuocChiTietFacade toaThuocChiTietF;
    @EJB
    private ToaThuocFacade toaThuocF;
    @PersistenceContext(unitName = "clinicPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    @EJB
    private ThuocFacade thuocF;
    @EJB
    private NhanVienFacade nhanVienF;
    private BenhNhanFacade benhNhanF;
    @PersistenceContext(unitName = "clinicPU")

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();                       
        switch (action) {
              
                case "getToaPT":

                    List<ToaThuoc> listTT = toaThuocF.getToa(2);
                    List<ToaInfo> listTTjs = new ArrayList<>();
                    listTT.forEach((ToaThuoc tt) -> {
                        ToaInfo infoTT = new ToaInfo(tt.getId(), tt.getNgayTao(), tt.getChanDoan(), tt.getIdBenhNhan().getId(), tt.getIdBacSi().getId(), tt.getIdPhatThuoc().getId(), tt.getTinhTrang());
                        //.println(gson.toJson(info));    
                        listTTjs.add(infoTT);
                    });
                    String outputTT = gson.toJson(listTTjs);
                    out.println(outputTT);
                    listTT.forEach((ToaThuoc tt) -> {
                        try {
                            utx.begin();//Bắt đầu transaction
                            tt.setTinhTrang(3);
                            em.merge(tt);
                            utx.commit();
                        } catch (Exception e) {
                            //result = "Exception: " + e.getMessage();
                            e.printStackTrace();
                            try {
                                utx.rollback();//Rollback (undo) transaction
                            } catch (Exception ex) {
                                e.printStackTrace();
                            }
                        }
                    });
                    //System.out.println(output);
                    break;
                case "getMedPT":
                    String searchTxt = request.getParameter("txt");
                    List<Thuoc> listT = thuocF.findByName(searchTxt);
                    listT.forEach((Thuoc t) -> {
                        out.println("<tr id=\"listT\">\n"
                                + "        	<td>" + t.getId() + "</td>\n"
                                + "        	<td>" + t.getTenThuoc() + "</td>\n"
                                + "        	<td>" + t.getSoLuong() + "</td>\n"
                                + "               </tr>");
                    });
                    break;
                case "showPT":
                    List<NhanVien> listNV = nhanVienF.getByRole("PhatThuoc");
                    List<NhanVienInfo> listNvjs = new ArrayList<>();
                    listNV.forEach((NhanVien nv) -> {
                        NhanVienInfo infoNV = new NhanVienInfo(nv.getId(), nv.getHo(), nv.getTen(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getIdUser().getId());
                        //.println(gson.toJson(info));    
                        listNvjs.add(infoNV);
                    });
                    String outputNV = gson.toJson(listNvjs);
                    out.println(outputNV);
                    break;
                case "getToaAsBNPT":
                    int idbntoa = Integer.parseInt((request.getParameter("id")));
                    List<ToaThuoc> listTTByIdbn = toaThuocF.getByIdBnPT(idbntoa);
                    ToaThuoc tt = listTTByIdbn.get(0);
                    ToaInfo TTInfo = new ToaInfo(tt.getId(), tt.getNgayTao(), tt.getChanDoan(), tt.getIdBenhNhan().getId(), tt.getIdBacSi().getId(), tt.getIdPhatThuoc().getId(), tt.getTinhTrang());
                    String outputTTPT = gson.toJson(TTInfo);
                    out.println(outputTTPT);
                    break;
                case "getToaCTAsBNPT":
                    int idbntoaCT = Integer.parseInt((request.getParameter("id")));
                    List<ToaThuocChiTiet> listTTCTByIdbn = toaThuocChiTietF.getByIdBn(idbntoaCT);
                    listTTCTByIdbn.forEach((ToaThuocChiTiet t) -> {
                        out.println("<tr>\n"
                                + "        	<td>" + t.getIDToaThuoc().getId() + "</td>\n"
                                + "        	<td>" + t.getIDThuoc().getTenThuoc() + "</td>\n"
                                + "        	<td>" + t.getSang() + "</td>\n"
                                + "        	<td>" + t.getChieu() + "</td>\n"
                                + "        	<td>" + t.getToi() + "</td>\n"
                                + "        	<td>" + t.getCachDung() + "</td>\n"
                                + "               </tr>");
                    });
                    break;
            }

        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
