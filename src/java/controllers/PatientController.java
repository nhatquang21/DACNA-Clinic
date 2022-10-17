/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.BenhNhan;
import entities.NhanVien;
import entities.ToaThuoc;
import entities.User;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sessionbeans.BenhNhanFacade;
import sessionbeans.ToaThuocFacade;
import utils.Config;
import utils.Hasher;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "PatientController", urlPatterns = {"/patient"})

public class PatientController extends HttpServlet {

    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    @EJB
    private ToaThuocFacade ttf;
    @EJB
    private BenhNhanFacade bnf;
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
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");

        if (user == null || !user.getRole().equals("TiepTan")) {
            response.sendRedirect(Config.ROOT + "/account/login.do");
            session.setAttribute("result1", "You do not have this permission !!");
        } else {
            boolean forward = true;

            String action = request.getAttribute("action").toString();

            switch (action) {
                case "find_patient_form":
                    forward = find_patient_form(request, response);

                    break;
                case "find_patient":
                    forward = find_patient(request, response);

                    break;
                case "find_patient_handle":
                    find_patient_handle(request, response);

                    break;
                case "register_form":
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                    register_form(request, response);

                    break;
                case "update_form":
                    forward = update_form(request, response);

                    break;
                case "update_patient":
                    forward = update_patient(request, response);

                    break;
                case "register":
                    register(request, response);
                    break;

            }
            if (forward) {
                request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
            }

        }
    }

    public void register_form(HttpServletRequest request, HttpServletResponse response) {

    }

    public void register(HttpServletRequest request, HttpServletResponse response) {

        String result = null;
        String lname = request.getParameter("txtHo");
        String name = request.getParameter("txtTen");
        String email = request.getParameter("txtEmail");
        String address = request.getParameter("txtAddress");
        String gender = request.getParameter("txtGender");
        String phone = request.getParameter("txtPhone");
        boolean checkDuplicateEmail = bnf.checkDuplicateEmail(email);
        boolean checkDuplicatePhone = bnf.checkDuplicatePhone(phone);
        boolean checkEmailUserFromEmpl = bnf.checkDuplicateEmailFromPatient(email);

        System.out.println(lname + " " + name);
        if (!checkDuplicateEmail && !checkEmailUserFromEmpl && !checkDuplicatePhone) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dob = sdf.parse(request.getParameter("txtBirth"));
                utx.begin();//Bắt đầu transaction
                User user = new User();
                user.setUserID(email);
                user.setPassword(Hasher.hash("1"));
                user.setRole("BenhNhan");
                System.out.println(gender);
                em.persist(user);
                BenhNhan bn = new BenhNhan();
                bn.setHo(lname);
                bn.setTen(name);
                bn.setEmail(email);
                bn.setDiaChi(address);
                bn.setSdt(phone);
                bn.setGioiTinh(gender);
                bn.setNgaySinh(dob);
                bn.setIdUser(user);
                em.persist(bn);
                NhanVien nv = new NhanVien();
                nv.setId(16);
                ToaThuoc tt = new ToaThuoc();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                Date prs = sdf.parse(formatter.format(date));
                tt.setIdBenhNhan(bn);
                tt.setNgayTao(prs);
                tt.setTinhTrang(0);
                tt.setIdBacSi(nv);
                tt.setIdPhatThuoc(nv);
                em.persist(tt);
                utx.commit();
                result = "Đăng ký thành công";
                System.out.println(name);
            } catch (Exception e) {
                result = "Exception: " + e.getMessage();
                e.printStackTrace();
                try {
                    utx.rollback();//Rollback (undo) transaction
                } catch (Exception ex) {
                    e.printStackTrace();
                }
            }
        } else {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dob = sdf.parse(request.getParameter("txtBirth"));
                request.setAttribute("txtHo", lname);
                request.setAttribute("txtTen", name);
                request.setAttribute("txtEmail", email);
                request.setAttribute("txtAddress", address);
                request.setAttribute("txtGender", gender);
                request.setAttribute("txtGender", gender);
                request.setAttribute("txtPhone", phone);
                request.setAttribute("txtBirth", dob);
                result = "Email hoặc số điện thoại đã tồn tại ! ";
                request.setAttribute("action", "register_form");
            } catch (Exception e) {
                result = "Exception: " + e.getMessage();
                e.printStackTrace();
                try {
                    utx.rollback();//Rollback (undo) transaction
                } catch (Exception ex) {
                    e.printStackTrace();
                }
            }

        }

        request.setAttribute("result", result);
        request.setAttribute("action", "register_form");
    }

    public boolean update_form(HttpServletRequest request, HttpServletResponse response) {
        String result = null;
        int id = Integer.parseInt(request.getParameter("id"));
        try {

            BenhNhan bn = em.find(BenhNhan.class, id);
            request.setAttribute("bn", bn);
            System.out.println("Bệnh nhân " + bn.getIdUser().getId());
            request.setAttribute("result", result);
            request.setAttribute("action", "update_form");
            return true;

        } catch (Exception e) {
            result = "Exception: " + e.getMessage();
            e.printStackTrace();
            try {
                utx.rollback();//Rollback (undo) transaction
            } catch (Exception ex) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean update_patient(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        //Khai báo file
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("UTF-8");
        String result = null;
        String id = null;
        String fileName = null;
        String idUser = null;
        String lname = null;
        String name = null;
        String email = null;
        String address = null;
        String gender = null;
        String phone = null;
        String birth = null;

        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);

            for (FileItem item : items) {
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString("UTF-8");
                    System.out.println(fieldName);
                    System.out.println(fieldValue);
                    switch (fieldName) {
                        case "txtId":
                            id = fieldValue;
                            break;
                        case "txtTen":
                            name = fieldValue;
                            break;
                        case "txtHo":
                            lname = fieldValue;
                            break;
                        case "txtIdUser":
                            idUser = fieldValue;
                            break;
                        case "txtEmail":
                            email = fieldValue;
                            break;
                        case "txtAddress":
                            address = fieldValue;
                            break;
                        case "txtPhone":
                            phone = fieldValue;
                            break;
                        case "txtGender":
                            gender = fieldValue;
                            break;
                        case "txtBirth":
                            birth = fieldValue;
                            break;
                    }
                    fileName = String.format("%s.jpg", id);
                } else {
                    save(item, fileName);
                }
            }
            System.out.println("info vừa nhập" + id);
            request.setAttribute("fileName", fileName);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
        }

//        Integer idUser = Integer.parseInt(request.getParameter("txtIdUser"));
//        Integer id = Integer.parseInt(request.getParameter("txtId"));
//        String lname = request.getParameter("txtHo");
//        String name = request.getParameter("txtTen");
//        String email = request.getParameter("txtEmail");
//        String address = request.getParameter("txtAddress");
//        String gender = request.getParameter("txtGender");
//        String phone = request.getParameter("txtPhone");
        boolean checkPatientExist = bnf.checkDuplicatePatient(email, phone);
        System.out.println(checkPatientExist);
        boolean checkEmailExist = bnf.checkDuplicateEmail(email);
        boolean checkPhoneExist = bnf.checkDuplicatePhone(phone);
        BenhNhan bn = new BenhNhan();
//        if(!checkPatientExist || checkEmailExist && bn.getEmail().equals(email)){
//            
//        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = sdf.parse(birth);
            User user = em.find(User.class, Integer.parseInt(idUser));

            utx.begin();
            bn.setId(Integer.parseInt(id));
            bn.setHo(lname);
            bn.setTen(name);
            bn.setEmail(email);
            bn.setDiaChi(address);
            bn.setSdt(phone);
            bn.setIdUser(user);
            bn.setGioiTinh(gender);
            bn.setNgaySinh(dob);
            em.merge(bn);
            user.setUserID(email);
            em.merge(user);

            System.out.println(bn);
            utx.commit();
            result = "Cập nhật thông tin bệnh nhân thành công";
            request.setAttribute("result", result);

        } catch (Exception e) {
            result = "Exception: " + e.getMessage();
            e.printStackTrace();
            try {
                utx.rollback();//Rollback (undo) transaction
            } catch (Exception ex) {
                e.printStackTrace();
            }
        }
        request.setAttribute("bn", bn);

        request.setAttribute("action", "update_form");
        return true;
//        } else {
//
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                Date dob = sdf.parse(request.getParameter("txtBirth"));
//
//                request.setAttribute("txtTen", name);
//                request.setAttribute("txtEmail", email);
//                request.setAttribute("txtAddress", address);
//                request.setAttribute("txtGender", gender);
//                request.setAttribute("txtGender", gender);
//                request.setAttribute("txtPhone", phone);
//                request.setAttribute("txtBirth", dob);
//
//                result = "Email hoặc số điện thoại đã tồn tại ! ";
//                request.setAttribute("action", "update_form");
//                return true;
//            } catch (Exception e) {
//                result = "Exception: " + e.getMessage();
//                e.printStackTrace();
//                try {
//                    utx.rollback();//Rollback (undo) transaction
//                } catch (Exception ex) {
//                    e.printStackTrace();
//                }
//            }
//
//        }

    }

    private void save(FileItem item, String fileName) throws Exception {
        String absolutePath = getServletContext().getRealPath("/images/");
        String filePath1 = absolutePath + "\\" + fileName;
        String filePath2 = getServletContext().getRealPath("/") + "..\\..\\web\\images\\" + fileName;
        System.out.println(filePath1);
        System.out.println(filePath2);
        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        item.write(file1);
        item.write(file2);
    }

    public boolean find_patient_form(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    public boolean find_patient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            String result = null;
            String info = request.getParameter("txtInfo");
            String option = request.getParameter("txtChoice");

            if (option.equals("sdt")) {

                BenhNhan bn = bnf.selectBenhNhanSDT(info);
                if (bn == null) {
                    result = "Không tìm thấy bệnh nhân với số điện thoại đã nhập";
                    request.setAttribute("result", result);
                    request.setAttribute("option", option);
                    request.setAttribute("info", info);
                    request.setAttribute("action", "find_patient_form");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                    return false;

                } else {

                    HttpSession session = request.getSession();
                    session.setAttribute("bn", bn);
                    return true;
                }

            } else if (option.equals("email")) {

                BenhNhan bn = bnf.selectBenhNhanEmail(info);
                if (bn == null) {

                    result = "Không tìm thấy bệnh nhân với email đã nhập";
                    request.setAttribute("result", result);
                    request.setAttribute("option", option);
                    request.setAttribute("info", info);
                    request.setAttribute("action", "find_patient_form");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                    return false;

                } else {

                    request.setAttribute("bn", bn);
                    return true;
                }
            }
        }
        return true;
    }

    public void find_patient_handle(HttpServletRequest request, HttpServletResponse response) {

        String result = null;
        String lname = request.getParameter("txtHo");
        String name = request.getParameter("txtTen");
        String email = request.getParameter("txtEmail");
        String address = request.getParameter("txtAddress");
        String gender = request.getParameter("txtGender");
        String phone = request.getParameter("txtPhone");
        HttpSession session = request.getSession();
        BenhNhan bn = (BenhNhan) session.getAttribute("bn");

        boolean checkPatientExist = bnf.checkDuplicatePatient(email, phone);
        System.out.println(checkPatientExist);
        if (!checkPatientExist) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dob = sdf.parse(request.getParameter("txtBirth"));

                utx.begin();//Bắt đầu transaction

                NhanVien nv = new NhanVien();
                nv.setId(16);
                ToaThuoc tt = new ToaThuoc();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                Date prs = sdf.parse(formatter.format(date));
                tt.setIdBenhNhan(bn);
                tt.setNgayTao(prs);
                tt.setTinhTrang(0);
                tt.setIdBacSi(nv);
                tt.setIdPhatThuoc(nv);
                em.persist(tt);
                utx.commit();
                result = "Đăng ký khám bệnh thành công";
                System.out.println(name);
            } catch (Exception e) {
                result = "Exception: " + e.getMessage();
                e.printStackTrace();
                try {
                    utx.rollback();//Rollback (undo) transaction
                } catch (Exception ex) {
                    e.printStackTrace();
                }
            }
        } else {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dob = sdf.parse(request.getParameter("txtBirth"));
                request.setAttribute("txtHo", lname);
                request.setAttribute("txtTen", name);
                request.setAttribute("txtEmail", email);
                request.setAttribute("txtAddress", address);
                request.setAttribute("txtGender", gender);
                request.setAttribute("txtGender", gender);
                request.setAttribute("txtPhone", phone);
                request.setAttribute("txtBirth", dob);
                result = "Số điện thoại đã tồn tại ! ";
                request.setAttribute("action", "find_patient");
            } catch (Exception e) {
                result = "Exception: " + e.getMessage();
                e.printStackTrace();
                try {
                    utx.rollback();//Rollback (undo) transaction
                } catch (Exception ex) {
                    e.printStackTrace();
                }
            }

        }

        request.setAttribute("result", result);
        request.setAttribute("action", "find_patient");
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

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}
