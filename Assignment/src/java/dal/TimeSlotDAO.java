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
import model.TimeSlot;

/**
 *
 * @author DUC
 */
public class TimeSlotDAO extends DBContext {
    public ArrayList<TimeSlot> list(){
        ArrayList<TimeSlot> slots = new ArrayList<>();
        try {
            String sql = "select tid, description from TimeSlot";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                TimeSlot t = new TimeSlot();
                t.setTid(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
                slots.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slots;
    }
}
