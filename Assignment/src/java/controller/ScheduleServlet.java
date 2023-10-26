/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.SessionDAO;
import dal.TimeSlotDAO;
import help.DateTimeHelper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Session;
import model.TimeSlot;

/**
 *
 * @author DUC
 */
public class ScheduleServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int instructorid = Integer.parseInt(request.getParameter("iid"));
        String t_from = request.getParameter("from");
        String t_to = request.getParameter("to");
        ArrayList<Date> dates = new ArrayList<>();
        
        if(t_from == null){
            dates = DateTimeHelper.getCurrentWeekDates();
        } else{
            try {
                dates = DateTimeHelper.getSqlDatesInRange(t_from, t_to);
            } catch (ParseException ex) {
                Logger.getLogger(ScheduleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        TimeSlotDAO timeDAO = new TimeSlotDAO();
        ArrayList<TimeSlot> slots = timeDAO.list();
        
        SessionDAO sesDAO = new SessionDAO();
        ArrayList<Session> sessions = sesDAO.getSessions(dates.get(0), dates.get(dates.size()-1));
        
        request.setAttribute("slots", slots);
        request.setAttribute("dates", dates);
        request.setAttribute("from", dates.get(0));
        request.setAttribute("to", dates.get(dates.size()-1));
        request.setAttribute("sessions", sessions);
        
        request.getRequestDispatcher("schedule.jsp").forward(request, response);
        
      }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
