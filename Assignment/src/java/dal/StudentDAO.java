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
public class StudentDAO extends DBContext{
    public List<Student> getAll(){
        List<Student> list = new ArrayList<>();
        String sql = "select ID, name, code, gender, dob from Student";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("code"), rs.getBoolean("gender"), rs.getDate("dob"));
                list.add(s);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args){
        StudentDAO s = new StudentDAO();
        List<Student> list = s.getAll();
        System.out.println(list.get(1).getName());
    }
}
