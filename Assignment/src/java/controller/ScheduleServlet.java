/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SessionDAO;
import dal.StudentDAO;
import dal.TimeSlotDAO;
import help.DateTimeHelper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Group;
import model.Session;
import model.Student;
import model.TimeSlot;

/**
 *
 * @author DUC
 */
public class ScheduleServlet extends HttpServlet {

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
        HttpSession ses = request.getSession();
        TimeSlotDAO timeDAO = new TimeSlotDAO();
        SessionDAO sesDAO = new SessionDAO();

        ArrayList<Session> list = new ArrayList<>();

        int instructorid = Integer.parseInt(request.getParameter("iid"));
        String t_from = request.getParameter("from");
        String t_to = request.getParameter("to");
        ArrayList<Date> dates = new ArrayList<>();

        if (t_from == null) {
            dates = DateTimeHelper.getCurrentWeekDates();
        } else {
            try {
                dates = DateTimeHelper.getSqlDatesInRange(t_from, t_to);
            } catch (ParseException ex) {
                Logger.getLogger(ScheduleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ArrayList<TimeSlot> slots = timeDAO.list();

        Account a = (Account) ses.getAttribute("acc");
        if (a.getRole() != 3) {
            Student t = (Student) ses.getAttribute("info");
            int id = t.getId();
            ArrayList<Session> sessions = sesDAO.getSessionsbyStudent(dates.get(0), dates.get(dates.size() - 1), id);

            ArrayList<Integer> index = new StudentDAO().getGroupByStu(id);

            for (int i = 0; i < sessions.size(); i++) {
                for (int j = 0; j < index.size(); j++) {
                    if (index.get(j) == sessions.get(i).getGroup().getGid()) {
                        list.add(sessions.get(i));
                        continue;
                    }
                }
            }
        }else{
            list = sesDAO.getSessions(dates.get(0), dates.get(dates.size() - 1));
        }

        request.setAttribute("slots", slots);
        request.setAttribute("dates", dates);
        request.setAttribute("from", dates.get(0));
        request.setAttribute("to", dates.get(dates.size() - 1));
        request.setAttribute("sessions", list);

        request.getRequestDispatcher("schedule.jsp").forward(request, response);

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
