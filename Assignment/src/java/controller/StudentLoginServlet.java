/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AccDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Instructor;
import model.Student;

/**
 *
 * @author DUC
 */
public class StudentLoginServlet extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String op = request.getParameter("op");
        HttpSession session = request.getSession();
        session.setAttribute("op", op);
        if (op.equals("campus")){
            request.setAttribute("er", "Please choose campus before login!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("login.jsp").forward(request, response);    
        }   
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user = request.getParameter("student_user");
        String pass = request.getParameter("student_pass");
        String op = request.getParameter("op");
        HttpSession session = request.getSession();
          //session.setAttribute("op", op);
        AccDAO acc = new AccDAO();
        Account a = acc.checkAcc(user, pass);
        if (a!=null){
          if (a.getRole()!=3){
                session.setAttribute("acc", a);
             Student st = acc.getAcc(user);
           session.setAttribute("info", st);
          }
          if (a.getRole()==3){
              session.setAttribute("acc", a);
              Instructor st = acc.getAccIns(user);
           session.setAttribute("info", st);
          }
         
            
            request.getRequestDispatcher("server.jsp").forward(request, response);
        }else{
            request.setAttribute("er", "Wrong username or password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
