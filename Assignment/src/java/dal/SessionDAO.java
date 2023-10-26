/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Room;
import model.Session;
import model.Subject;
import model.TimeSlot;

/**
 *
 * @author DUC
 */
public class SessionDAO extends DBContext {

    public ArrayList<Session> getSessions( Date from, Date to){
    ArrayList<Session> sessions = new ArrayList<>();
        try{
        String sql = "select s.seid, s.date, r.roomid, t.tid, g.gid, g.gname, su.subid, su.subname, i.iid, i.iname, s.isAtt from Session s\n"
                + "INNER JOIN [Group] g ON g.gid = s.gid\n"
                + "INNER JOIN [room] r ON r.roomid = s.rid\n"
                + "INNER JOIN [TimeSlot] t ON t.tid = s.tid\n"
                + "INNER JOIN [Subject] su ON su.subid = s.subid\n"
                + "INNER JOIN [Instructor] i ON i.iid = s.iid\n"
                + "Where s.[date] >=? AND s.[date] <= ?";
        
        PreparedStatement st = connection.prepareStatement(sql);
        //st.setInt(1, iid);
        st.setDate(1, from);
        st.setDate(2, to);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Session session = new Session();
            session.setSeid(rs.getInt("seid"));
            session.setDate(rs.getDate("date"));
            session.setIsAtt(rs.getBoolean("isAtt"));
            
            Room room = new Room();
            room.setRoomid(rs.getString("roomid"));
            session.setRoom(room);
            
            TimeSlot t = new TimeSlot();
            t.setTid(rs.getInt("tid"));
            session.setTime(t);
            
            Group g = new Group();
            g.setGid(rs.getInt("gid"));
            g.setName(rs.getString("gname"));
            session.setGroup(g);
            
            Subject su = new Subject();
            su.setSubid(rs.getInt("subid"));
            su.setName(rs.getString("subname"));
            session.setSubject(su);
            
            sessions.add(session);
        }
    }   catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }
   
    public Session get(Session entity){
        ArrayList<Session> sessions = new ArrayList<>();
        try{
        String sql = "select s.seid, s.date, r.roomid, t.tid, g.gid, g.gname, su.subid, su.subname, i.iid, i.iname, s.isAtt from Session s\n"
                + "INNER JOIN [Group] g ON g.gid = s.gid\n"
                + "INNER JOIN [room] r ON r.roomid = s.rid\n"
                + "INNER JOIN [TimeSlot] t ON t.tid = s.tid\n"
                + "INNER JOIN [Subject] su ON su.subid = s.subid\n"
                + "INNER JOIN [Instructor] i ON i.iid = s.iid\n"
                + "Where s.seid = ?";
        
        PreparedStatement st = connection.prepareStatement(sql);
        //st.setInt(1, iid);
        st.setInt(1, entity.getSeid());
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Session session = new Session();
            session.setSeid(rs.getInt("seid"));
            session.setDate(rs.getDate("date"));
            session.setIsAtt(rs.getBoolean("isAtt"));
            
            Room room = new Room();
            room.setRoomid(rs.getString("roomid"));
            session.setRoom(room);
            
            TimeSlot t = new TimeSlot();
            t.setTid(rs.getInt("tid"));
            session.setTime(t);
            
            Group g = new Group();
            g.setGid(rs.getInt("gid"));
            g.setName(rs.getString("gname"));
            session.setGroup(g);
            
            Subject su = new Subject();
            su.setSubid(rs.getInt("subid"));
            su.setName(rs.getString("subname"));
            session.setSubject(su);
            
            return session;
        }
    }   catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
