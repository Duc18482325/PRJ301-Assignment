/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.Instructor;
import model.Student;

/**
 *
 * @author DUC
 */
public class AccDAO extends DBContext {

    public Account checkAcc(String user, String pass) {
        String sql = "select * from Account where [user]=? and [pass]=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getString("user"),
                        rs.getString("pass"),
                        rs.getInt("role"));
                return a;
            }

        } catch (SQLException e) {

        }
        return null;
    }

    public Student getAcc(String user) {
        String sql = "select*from Student s join Account a on s.code = a.code \n"
                + "where [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student a = new Student(rs.getInt("stuid"), rs.getString("stuname"), rs.getString("code"), rs.getBoolean("gender"), rs.getDate("dob"));
                return a;
            }

        } catch (SQLException e) {

        }
        return null;
    }
    
    public Instructor getAccIns(String user) {
        String sql = "select*from Instructor i join Account a on i.code = a.code where [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Instructor i = new Instructor(rs.getInt("iid"), rs.getString("iname"));
                return i;
            }

        } catch (SQLException e) {

        }
        return null;
    }
    public static void main(String[] args) {
        Instructor i = new AccDAO().getAccIns("sa@a");
      //  System.out.println(i.getIid());
    }
}
