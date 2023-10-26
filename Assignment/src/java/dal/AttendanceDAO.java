/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Session;
import model.Student;

/**
 *
 * @author DUC
 */
public class AttendanceDAO extends DBContext {

    public ArrayList<Attendance> getAttendance(int seid) {
        ArrayList<Attendance> attlist = new ArrayList<>();
        try {
            String sql = "select s.stuid as id, s.stuname as name, ISNULL(a.status, 0) as sta, ISNULL(a.description, '') as des, ISNULL(a.att_datetime, GETDATE()) as att, a.seid from [Session] se \n" +
"                     INNER JOIN [group] g ON se.gid = g.gid \n" +
"                     INNER JOIN [Group_Student] gst ON gst.gid = g.gid \n" +
"                     INNER JOIN [Student] s ON s.stuid = gst.stuid \n" +
"                     LEFT JOIN Attendance a ON a.stuid = s.stuid AND se.seid = a.seid\n" +
"                     Where se.seid = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, seid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Attendance att = new Attendance();
                Student student = new Student();
                Session session = new Session();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));

                session.setSeid(seid);
                att.setStudent(student);
                att.setSession(session);
                att.setStatus(rs.getBoolean("sta"));
                att.setDescription(rs.getString("des"));
                att.setDatetime(rs.getTimestamp("att"));
                attlist.add(att);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attlist;
    }
    
    public static void main(String[] args) {
        AttendanceDAO attDAO = new AttendanceDAO();
        ArrayList<Attendance> attlist = attDAO.getAttendance(24);
        
        System.out.println(attlist.get(0).getStudent());
    }
}
