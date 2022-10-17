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
import java.io.IOException;
import java.io.PrintWriter;
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
import sessionbeans.NhanVienFacade;
import sessionbeans.ToaThuocFacade;
import sessionbeans.UserFacade;
import utils.Config;
import utils.Hasher;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AccountController", urlPatterns = {"/account"})
public class AccountController extends HttpServlet {

    @PersistenceContext(unitName = "clinicPU")
    private EntityManager em;
    @EJB
    private NhanVienFacade nf;
    @EJB
    private ToaThuocFacade ttf;
    @Resource
    private javax.transaction.UserTransaction utx;

    @EJB
    private UserFacade uf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getAttribute("action").toString();
        boolean forward = true;
        request.setCharacterEncoding("UTF-8");
        switch (action) {
            case "profile":
                forward = profile(request, response);
                if (forward) {
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "profile_handler":

                profile_handler(request, response);

                break;
            case "login":

                forward = login(request, response);
                if (forward) {
                    request.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(request, response);
                }
                break;
            case "login_handler":

                forward = login_handler(request, response);
                if (forward) {
                    request.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(request, response);
                }
                break;
            case "sign_up":

                forward = sign_up(request, response);

                if (forward) {
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "sign_up_form":

                forward = sign_up_form(request, response);
                if (forward) {
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "logout":
                forward = logout(request, response);
                if (forward) {
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "show_patient_history":
                forward = showPatientHistory(request, response);
                if (forward) {
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            default:
                request.setAttribute("action", "error");

        }

    }

    public boolean showPatientHistory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String result = null;
        if (user != null && user.getRole().equals("BenhNhan")) {
            List<ToaThuoc> list = ttf.getByIdUser(user.getId());
            list.forEach(tt -> tt.getIdBenhNhan());
            request.setAttribute("list", list);
            return true;

        } else {

            response.sendRedirect(Config.ROOT + "/account/login.do");
            session.setAttribute("result1", "You do not have this permission");
            return false;
        }

    }

    public boolean profile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        if (user == null) {

            response.sendRedirect(Config.ROOT + "/account/login.do");
            return false;

        } else if (user != null) {

            return true;
        }
        return true;
    }

    public void profile_handler(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String result = "";
        User user = (User) session.getAttribute("account");
        String userPwd = user.getPassword();
        String pwd = request.getParameter("txtPwd");
        String newPwd = request.getParameter("txtNewPwd");
        String confPwd = request.getParameter("txtConfPwd");
        if (userPwd.equals(Hasher.hash(pwd))) {

            if (newPwd.equals(confPwd) && !newPwd.equals(pwd)) {
                try {

                    utx.begin();//Bắt đầu transaction

                    user.setPassword(Hasher.hash(newPwd));

                    em.merge(user);

                    utx.commit();
                    result = "Đổi mật khẩu thành công";
                    request.setAttribute("result", result);
                    // request.setAttribute("controller", "account");
                    request.setAttribute("action", "login");
                    request.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(request, response);

                } catch (Exception e) {
                    result = "Exception: " + e.getMessage();
                    e.printStackTrace();
                    try {
                        utx.rollback();//Rollback (undo) transaction
                    } catch (Exception ex) {
                        e.printStackTrace();
                    }
                    request.setAttribute("action", "profile");
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
            }

        } else {
            result = "Mật khẩu cũ không đúng";
            request.setAttribute("result", result);
            request.setAttribute("controller", "account");
            request.setAttribute("action", "profile");
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);

        }

    }

    public boolean login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return true;
    }

    public boolean login_handler(HttpServletRequest request, HttpServletResponse response) {
        String result = null;
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = uf.selectAccount(email, password);

            if (user == null) {

                result = "Please check your email or password.";
                request.setAttribute("result1", result);
                request.setAttribute("email", email);
                request.setAttribute("password", password);
                request.setAttribute("controller", "account");
                request.setAttribute("action", "login");
                return true;
            } else {

                //Lưu account vào session
                HttpSession session = request.getSession();
                session.setAttribute("account", user);
                //Quay về Home Page
                response.sendRedirect(Config.ROOT + "/home/dashboard.do");
                return false;
            }
        } catch (Exception e) {
            result = "Exception: " + e.getMessage();
            e.printStackTrace();

            request.setAttribute("controller", "account");
            request.setAttribute("action", "login");

        }
        request.setAttribute("result", result);
        return true;
    }

    public boolean sign_up(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = null;
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");

        if (account == null || !account.getRole().equals("Admin")) {
            response.sendRedirect(Config.ROOT + "/account/login.do");
            request.setAttribute("result1", "You do not have this permission");
        } else {
            try {
                String lname = request.getParameter("txtHo");
                String name = request.getParameter("txtTen");
                String email = request.getParameter("txtEmail");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dob = sdf.parse(request.getParameter("txtBirth"));
                String address = request.getParameter("txtAddress");
                String role = request.getParameter("txtRole");
                String phone = request.getParameter("txtPhone");
             
                utx.begin();//Bắt đầu transaction
                User user = new User();
                user.setUserID(email);
                user.setPassword(Hasher.hash("1"));
                user.setRole(role);
                em.persist(user);

                NhanVien nv = new NhanVien();
                nv.setHo(lname);
                nv.setTen(name);
                nv.setEmail(email);
                nv.setDiaChi(address);
                nv.setSdt(phone);

                nv.setNgaySinh(dob);
                nv.setIdUser(user);
                em.persist(nv);

                utx.commit();
                result = "Đăng ký thành công";
                request.setAttribute("result", result);
                response.sendRedirect(Config.ROOT + "/home/index.do");
                return false;

            } catch (Exception e) {
                result = "Exception: " + e.getMessage();
                e.printStackTrace();
                try {
                    utx.rollback();//Rollback (undo) transaction
                } catch (Exception ex) {
                    e.printStackTrace();
                }
            }

            request.setAttribute("result", result);
            request.setAttribute("action", "sign_up_form");

        }
        return true;
    }

    public boolean sign_up_form(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
        if (account == null || !account.getRole().equals("Admin")) {
            response.sendRedirect(Config.ROOT + "/account/login.do");
            request.setAttribute("result1", "You do not have this permission");
            return false;
        } else {
            return true;
        }

    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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

    public boolean logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("result1", "");
        session.invalidate();
        //Quay về Home Page

        response.sendRedirect(Config.ROOT + "/home/dashboard.do");
        return false;
    }

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
