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
import model.Attendance;
import model.Group;
import model.Instructor;
import model.Room;
import model.Session;
import model.Student;
import model.Subject;
import model.TimeSlot;

/**
 *
 * @author DUC
 */
public class SessionDAO extends DBContext {

    public ArrayList<Session> getSessions(Date from, Date to) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "select s.seid, s.date, r.roomid, t.tid, t.description, g.gid, g.gname, su.subid, su.subname, i.iid, i.iname, s.isAtt from Session s\n"
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
            while (rs.next()) {
                Session session = new Session();
                session.setSeid(rs.getInt("seid"));
                session.setDate(rs.getDate("date"));
                session.setIsAtt(rs.getBoolean("isAtt"));

                Room room = new Room();
                room.setRoomid(rs.getString("roomid"));
                session.setRoom(room);

                TimeSlot t = new TimeSlot();
                t.setTid(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
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
        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    public ArrayList<Session> getSessionsbyStudent(Date from, Date to, int id) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            String sql = "select distinct st.stuname, a.status, s.seid, s.date, r.roomid, t.tid, t.description, g.gid, g.gname, su.subid, su.subname from Session s\n"
                    + "                     INNER JOIN [Group] g ON g.gid = s.gid\n"
                    + "                     INNER JOIN [room] r ON r.roomid = s.rid\n"
                    + "                     INNER JOIN [TimeSlot] t ON t.tid = s.tid\n"
                    + "                     INNER JOIN [Subject] su ON su.subid = s.subid\n"
                    + "		 join Attendance a on a.seid = s.seid\n"
                    + "					 join Group_Student gs on gs.gid =g.gid\n"
                    + "					 join Student st on st.stuid = gs.stuid\n"
                    + "					 where st.stuid = ? "
                    + "and s.[date] >=? AND s.[date] <= ?";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setDate(2, from);
            st.setDate(3, to);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Session session = new Session();
                session.setSeid(rs.getInt("seid"));
                session.setDate(rs.getDate("date"));
                session.setIsAtt(rs.getBoolean("status"));

                Room room = new Room();
                room.setRoomid(rs.getString("roomid"));
                session.setRoom(room);

                TimeSlot t = new TimeSlot();
                t.setTid(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
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
        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    public Session get(Session entity) {
        try {
            String sql = "select s.seid, s.date, r.roomid, t.tid, t.description, g.gid, g.gname, su.subid, su.subname, i.iid, i.iname, s.isAtt from Session s\n"
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
            while (rs.next()) {
                Session session = new Session();
                session.setSeid(rs.getInt("seid"));
                session.setDate(rs.getDate("date"));
                session.setIsAtt(rs.getBoolean("isAtt"));

                Room room = new Room();
                room.setRoomid(rs.getString("roomid"));
                session.setRoom(room);

                TimeSlot t = new TimeSlot();
                t.setTid(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
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
        } catch (SQLException ex) {
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void AddAttendance(Session ses) {
        try {
            connection.setAutoCommit(false);
            String sql_update_isAtt = "UPDATE [Session] SET isAtt = 1 WHERE seid = ?";
            PreparedStatement st_update_isAtt = connection.prepareStatement(sql_update_isAtt);
            st_update_isAtt.setInt(1, ses.getSeid());
            st_update_isAtt.executeUpdate();

            String sql_remove_attlist = "DELETE Attendance WHERE seid =?";
            PreparedStatement st_remove_attlist = connection.prepareStatement(sql_remove_attlist);
            st_remove_attlist.setInt(1, ses.getSeid());
            st_remove_attlist.executeUpdate();

            for (Attendance attendance : ses.getAttlist()) {
                String sql_insert_att = "INSERT INTO [Attendance]\n"
                        + "           ([seid]\n"
                        + "           ,[stuid]\n"
                        + "           ,[status]\n"
                        + "           ,[description]\n"
                        + "           ,[att_datetime])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,GETDATE())";

                PreparedStatement st_insert_att = connection.prepareStatement(sql_insert_att);
                st_insert_att.setInt(1, ses.getSeid());
                st_insert_att.setInt(2, attendance.getStudent().getId());
                st_insert_att.setBoolean(3, attendance.isStatus());
                st_insert_att.setString(4, attendance.getDescription());
                st_insert_att.executeUpdate();
            }

            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(SessionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // getroom
    public ArrayList<Group> getGroup() {

        String com1 = " select gid,gname,iid,iname,s.subid,subname from [Group] g join Instructor i on g.sup_iid = i.iid join Subject s on g.subid = s.subid";
        ArrayList<Group> lr = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(com1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("gid");
                Group g = new Group();
                g.setGid(id);
                g.setName(rs.getString("gname"));

                Instructor i = new Instructor(rs.getInt("iid"), rs.getString("iname"));
                g.setSupervior(i);

                Subject s = new Subject(rs.getInt("subid"), rs.getString("subname"));
                g.setSubject(s);
                // 
                ArrayList<Student> stu = new SessionDAO().getStudentByGroup(id);

                g.setStudents(stu);

                lr.add(g);
            }

        } catch (SQLException e) {

        }

        return lr;
    }

    public ArrayList<Student> getStudentByGroup(int id) {
        ArrayList<Student> stu = new ArrayList<>();
        String com2 = "select s.stuid,stuname,code,gender,dob from Student s join Group_Student gs on s.stuid = gs.stuid\n"
                + "where gid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(com2);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student s1 = new Student(rs.getInt("stuid"), rs.getString("stuname"), rs.getString("code"), rs.getBoolean("gender"), rs.getDate("dob"));
                stu.add(s1);

            }
        } catch (SQLException e) {

        }
        return stu;

    }

    public static void main(String[] args) {
        ArrayList<Group> l = new SessionDAO().getGroup();
        ArrayList<Session> li = new SessionDAO().getSessionsbyStudent(Date.valueOf("2023-10-30"), Date.valueOf("2023-11-5"), 1);
        System.out.println(li.size());
    }

}
