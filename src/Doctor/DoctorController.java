/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doctor;

import DBConnection.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DoctorController {
    public static void insertData(Doctor doctor){
        try{
            String query = "insert into doctor values (null,?,?,?,?,?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getDegree());
            ps.setString(4, doctor.getPhoneNo());
            ps.setObject(5, doctor.getDateOfJoin());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Doctor added.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
    }
    
    public static List<Doctor> getDoctorList(){
        List<Doctor> list = new ArrayList<Doctor>();
        try{
        String query = "select * from doctor";
        PreparedStatement ps = DB.con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String specialization = rs.getString("specialization");
            String degree = rs.getString("degree");
            String phone = rs.getString("phone");
            Date date = rs.getDate("DateOfJoin");
            Doctor d = new Doctor(id,name,specialization,degree,phone,date);
            list.add(d);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
    }
        return list;
    }
    
    public static void deleteById(int id){
        try{
            String query = "delete from doctor where id = '"+id+"'";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleted");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
    }
    
    public static void updateById(Doctor d){
    try{
        String query = "update doctor set name = ?, specialization =? ,degree =?,phone = ? , DateOfJoin=? where id=?";
        PreparedStatement ps = DB.con.prepareStatement(query);
        ps.setString(1, d.getName());
        ps.setString(2, d.getSpecialization());
        ps.setString(3, d.getDegree());
        ps.setString(4, d.getPhoneNo());
        ps.setObject(5, d.getDateOfJoin());
        ps.setInt(6, d.getId());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Record Updated");
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,""+e);
    }
}
}
