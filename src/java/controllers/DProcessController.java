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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import sessionbeans.ToaThuocFacade;
import sessionbeans.UserFacade;
import utils.Config;

/**
 *
 * @author huytd
 */
@WebServlet(name = "DProcessController", urlPatterns = {"/dprocess"})
public class DProcessController extends HttpServlet {

    @EJB
    private NhanVienFacade nhanVienF;
    @EJB
    private ToaThuocFacade toaThuocF;
    @EJB
    private ThuocFacade thuocF;
    @EJB
    private UserFacade userF;
    @EJB
    private BenhNhanFacade benhNhanF;
    @PersistenceContext(unitName = "clinicPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        switch (action) {
            case "getPatient":
                int idbn = Integer.parseInt((request.getParameter("id")));
                BenhNhan b = benhNhanF.find(idbn);
                PatientInfo infoBN = new PatientInfo(b.getId(), b.getHo(), b.getTen(), b.getNgaySinh(), b.getDiaChi(), b.getSdt(), b.getEmail(), b.getGioiTinh(), b.getIdUser().getId());
                String outputBN = gson.toJson(infoBN);
                out.println(outputBN);
                //System.out.println(output);                
                break;
            case "getMed":
                String searchTxt = request.getParameter("txt");
                List<Thuoc> listT = thuocF.findByName(searchTxt);
                listT.forEach((Thuoc t) -> {
                    out.println("<tr ondblclick=\"addThuoc(this)\" id=\"listT\">\n"
                            + "        	<td>" + t.getId() + "</td>\n"
                            + "        	<td>" + t.getTenThuoc() + "</td>\n"
                            + "        	<td>" + t.getSoLuong() + "</td>\n"
                            + "               </tr>");
                });
                break;
            case "getToa":
                //Mới tiếp nhận (0) -> Chờ khám (1) -> Chờ phát thuốc (2) -> Hoàn tất (3)
                //Lấy ra danh sách toa thuốc (0)
                //Tạo array json gửi về client
                //Cập nhật tình trạng toa thuốc thành (1)                
                List<ToaThuoc> listTT = toaThuocF.getToa(0);
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
                        tt.setTinhTrang(1);
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
            case "getToaAsBN":
                int idbntoa = Integer.parseInt((request.getParameter("id")));
                List<Integer> listTTByIdbn = toaThuocF.getByIdBn(idbntoa);
                out.println(listTTByIdbn.get(0));
                break;
            case "showDoctor":
                List<NhanVien> listNV = nhanVienF.getByRole("BacSi");
                List<NhanVienInfo> listNvjs = new ArrayList<>();
                listNV.forEach((NhanVien nv) -> {
                    NhanVienInfo infoNV = new NhanVienInfo(nv.getId(), nv.getHo(), nv.getTen(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSdt(), nv.getEmail(), nv.getIdUser().getId());
                    //.println(gson.toJson(info));    
                    listNvjs.add(infoNV);
                });
                String outputNV = gson.toJson(listNvjs);
                out.println(outputNV);
                break;
            case "setToaInfo":
                int idbs = Integer.parseInt(request.getParameter("id"));
                String chandoan = request.getParameter("chandoan");
                int idtoa = Integer.parseInt(request.getParameter("idtoa").trim());
                ToaThuoc tt = toaThuocF.find(idtoa);
                try {
                    utx.begin();
                    tt.setChanDoan(chandoan);
                    NhanVien nv = new NhanVien();
                    nv.setId(idbs);
                    tt.setIdBacSi(nv);
                    em.merge(tt);
                    utx.commit();
                } catch (Exception e) {

                    e.printStackTrace();
                    try {
                        utx.rollback();
                    } catch (Exception ex) {
                        e.printStackTrace();
                    }
                }
                break;
            case "setToaCT":
                String result = null;
                String[] idtoaCT = gson.fromJson(request.getParameter("idtoa"), String[].class);
                String[] tenthuoc = gson.fromJson(request.getParameter("tenthuoc"), String[].class);
                String[] sang = gson.fromJson(request.getParameter("sang"), String[].class);
                String[] chieu = gson.fromJson(request.getParameter("chieu"), String[].class);
                String[] toi = gson.fromJson(request.getParameter("toi"), String[].class);
                String[] cachdung = gson.fromJson(request.getParameter("cachdung"), String[].class);
                for (int i = 0; i < idtoaCT.length; i++) {
                    try {
                        utx.begin();
                        ToaThuocChiTiet tct = new ToaThuocChiTiet();
                        ToaThuoc ttct = new ToaThuoc();
                        ttct.setId(Integer.parseInt(idtoaCT[i].trim()));
                        tct.setIDToaThuoc(ttct);
                        List<Thuoc> listt = thuocF.findByName(tenthuoc[i]);
                        Thuoc t = listt.get(0);
                        tct.setIDThuoc(t);
                        tct.setSang(sang[i]);
                        tct.setChieu(chieu[i]);
                        tct.setToi(toi[i]);
                        tct.setCachDung(cachdung[i]);
                        em.persist(tct);
                        utx.commit();
                        result = "Da them toa thuoc";
                    } catch (Exception e) {

                        e.printStackTrace();
                        try {
                            utx.rollback();
                        } catch (Exception ex) {
                            e.printStackTrace();
                        }
                    }
                }
                ToaThuoc ttup = toaThuocF.find(Integer.parseInt(idtoaCT[0].trim()));
                try {
                    utx.begin();//Bắt đầu transaction
                    ttup.setTinhTrang(2);
                    em.merge(ttup);
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
                out.println(result);
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
