/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.BenhNhan;
import entities.ToaThuoc;
import entities.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbeans.BenhNhanFacade;
import sessionbeans.ToaThuocFacade;
import utils.Config;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    @EJB
    private ToaThuocFacade ttf;
    @EJB
    private BenhNhanFacade bnf;

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
        String action = request.getAttribute("action").toString();
        boolean forward = true;
        switch (action) {
            case "index":
                forward = showTable(request, response);
                break;
            case "doctor":
//                forward = displayDoctor(request, response);
                break;
            case "medicine":
//                forward = displayMedicine(request, response);
                break;
            case "dashboard":
                break;
            default:
                request.setAttribute("action", "error");
        }
        //Chon view de hien ket qua
        if (forward) {
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    public boolean showTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        if (user == null || !user.getRole().equals("TiepTan")) {

            response.sendRedirect(Config.ROOT + "/account/login.do");
            session.setAttribute("result1", "You do not have this permission !!");
            return false;

        } else if (user != null) {
            String result = null;
            List<ToaThuoc> list = ttf.getTodayToaThuoc();
            list.forEach(tt -> tt.getIdBenhNhan());
            request.setAttribute("list", list);
            return true;
        }
        return true;

    }

//    public boolean displayDoctor(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("account");
//
//        if (user == null || !user.getRole().equals("BacSi")) {
//            response.sendRedirect(Config.ROOT + "/account/login.do");
//            session.setAttribute("result1", "You do not have this permission !!");
//            return false;
//        } else {
//            return true;
//        }
//
//    }

//    public boolean displayMedicine(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("account");
//
//        if (user == null || !user.getRole().equals("PhatThuoc")) {
//            response.sendRedirect(Config.ROOT + "/account/login.do");
//            session.setAttribute("result1", "You do not have this permission !!");
//            return false;
//        } else {
//            return true;
//        }
//
//    }

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
