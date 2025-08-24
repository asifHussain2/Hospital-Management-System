/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patient;

import DBConnection.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PatientController {
    public static void insertData(Patient p){
        try{
        String query1 = "select * from patient where roomNo ='"+p.getRoomNo()+"'";
        PreparedStatement ps1 = DB.con.prepareStatement(query1);
        ResultSet rs = ps1.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(null,"This room is allocated to another patient.");
        }
        else{
            String query = "insert into patient values (0,?,?,?,?,?,?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, p.getName());
            ps.setInt(2,p.getAge());
            ps.setString(3,p.getDisease());
            ps.setString(4,p.getAddress());
            ps.setInt(5, p.getRoomNo());
            ps.setObject(6, p.getDateadmitted());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Added.");
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
    }
    }
    
    public static List<Patient> getPatientList(){
        List<Patient> list = new ArrayList<Patient>();
        try{
            String query = "select * from patient";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            int id = rs.getInt("id");
            String name= rs.getString("name");
            int age = rs.getInt("age");
            String disease = rs.getString("disease");
            String address = rs.getString("address");
            int roomNo= rs.getInt("roomNo");
            Date date = rs.getDate("dateadmitted");
            Patient p = new Patient(id,name,age,disease,address,roomNo,date);
            list.add(p);
                    
                    
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
        
        
        return list;
    }

    public static Patient getPatientById(int id) {
        Patient p=null;
        try{
            String query = "select * from patient where id = '"+id+"'";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int idno = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String disease = rs.getString("disease");
                String address = rs.getString("address");
                int roomNo= rs.getInt("roomNo");
                Date date = rs.getDate("dateadmitted");
                p=new Patient(idno,name,age,disease,address,roomNo,date);
                
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
        return p;
    }

     public static void deleteById(int id) {
        try{
            String query = "delete from patient where id ='"+id+"'";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleted");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
    }

    public static void updateById(Patient p) {
        try{
            String query1 = "select * from patient where roomNo = '"+p.getRoomNo()+"' AND id != '"+p.getId()+"'";
            PreparedStatement ps1 = DB.con.prepareStatement(query1);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()){
                JOptionPane.showMessageDialog(null,"Sorry you cannot select this room , It is allocated to another patient.");
            }
            else{
            String query = "update patient set name= ? , age =?, disease = ?, address = ?, roomNo = ? ,dateadmitted =? where id = ?";
            PreparedStatement ps = DB.con.prepareStatement(query);
        
            ps.setString(1,p.getName());
            ps.setInt(2,p.getAge());
            ps.setString(3, p.getDisease());
            ps.setString(4, p.getAddress());
            ps.setInt(5, p.getRoomNo());
            ps.setObject(6, p.getDateadmitted());
            ps.setInt(7, p.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Updated.");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
    }
}
