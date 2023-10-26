/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AttendanceDAO;
import dal.SessionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Attendance;
import model.Session;
import model.Student;

/**
 *
 * @author DUC
 */
public class AttendanceServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AttendanceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendanceServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        SessionDAO sesDAO = new SessionDAO();
        Session s = new Session();
        int seid = Integer.parseInt(request.getParameter("seid"));
        s.setSeid(seid);
        Session ses = sesDAO.get(s);
        request.setAttribute("ses", ses);
        
        AttendanceDAO attDAO = new AttendanceDAO();
        ArrayList<Attendance> attlist = attDAO.getAttendance(seid);
        request.setAttribute("attlist", attlist);

        request.getRequestDispatcher("attendance.jsp").forward(request, response);
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
        String seid = request.getParameter("seid");
        String [] stuids = request.getParameterValues("stuid");
        ArrayList<Attendance> attlist = new ArrayList<>();
        Session ses = new Session();
        ses.setSeid(Integer.parseInt(request.getParameter("seid")));
        for (String stuid : stuids) {
            int id = Integer.parseInt(stuid);
            
            Attendance a = new Attendance();
            Student s = new Student();
            
            
            s.setId(id);
            
            a.setStudent(s);
            a.setSession(ses);
            a.setDescription(request.getParameter("description" + stuid));
            a.setStatus(request.getParameter("status" + stuid).equals("present"));
            attlist.add(a);
        }
        ses.setAttlist(attlist);
        
        SessionDAO sesDAO = new SessionDAO();
        sesDAO.AddAttendance(ses);
        HttpSession sess = request.getSession();
        sess.setAttribute("er", "Done");
        response.sendRedirect("attendance?seid=" + seid);
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
