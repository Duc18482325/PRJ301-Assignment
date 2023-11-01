/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DUC
 */
public class StudentDAO extends DBContext {

    public ArrayList<Student> getAll() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT ID, name, code, gender, dob FROM Student";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("code"), rs.getBoolean("gender"), rs.getDate("dob"));
                list.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Integer> getGroupByStu(int id) {
        String sql = "SELECT g.gid FROM Student s"
                + "INNER JOIN Group_Student gs ON s.stuid = gs.stuid\n"
                + "INNER JOIN [Group] g ON g.gid = gs.gid "
                + "WHERE s.stuid =  ?";
        ArrayList<Integer> l = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs= st.executeQuery();
            while (rs.next()){
                Integer i = new Integer(rs.getInt("gid"));
                l.add(i);
                
            }
            
        }catch(SQLException e){
            
        }
        
        return l;
    }

    public static void main(String[] args) {
        StudentDAO s = new StudentDAO();
        ArrayList<Integer> l = s.getGroupByStu(1);
        System.out.println(l.size());
    }
}
