/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Room;

import DBConnection.DB;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomController {
    public static void insertData(Room room){
        try{
            String query1="select * from room where roomNo = ? ";
            PreparedStatement ps1 = DB.con.prepareStatement(query1);
            ps1.setInt(1, room.getRoomNo());
            ResultSet rs= ps1.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"RoomNo is already Added");
                
            }
            else{
                String query = "insert into room values (null,?,?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setInt(1, room.getRoomNo());
            ps.setString(2, room.getCategory());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record inserted."); 
            }
           
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
    }
    
    public static List<Room> getRoomList(){
        List<Room> list = new ArrayList<Room>();
        try{
        String query = "select * from room";
        PreparedStatement ps = DB.con.prepareCall(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        int id= rs.getInt("id");
         int roomNo = rs.getInt("roomNo");
         String category = rs.getString("category");
        
         Room r = new Room(id,roomNo,category);
         list.add(r);
         
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
    }
        return list;
}
    
    public static Room getRoomById(int roomNo){
       Room r=null;
        try{         
            String query = "select roomNo, category from room where roomNo = '"+roomNo+"'";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int roomn = rs.getInt("roomNo");
                String category = rs.getString("category");
                r = new Room(0,roomn,category);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,""+e);
        }
        return r;
    }
    
    public static void deleteById(int roomNo){
    try{
        //CHecking patient is assigned this room
        String query1= "select * from patient where roomNo= '"+roomNo+"'";
         PreparedStatement ps1 = DB.con.prepareStatement(query1);
         ResultSet rs1 = ps1.executeQuery();
         if(rs1.next()){
           int no=  JOptionPane.showConfirmDialog(null, "Patient is assigned this room , Do you want to DeAllocate this room?");
           if(no==0){
               //for delete patient record
               String deletePatient = "delete from patient where roomNo= '"+roomNo+"'";
               PreparedStatement ps2 = DB.con.prepareStatement(deletePatient);
               ps2.executeUpdate();

               //for deleting room record
                String query ="delete from room where roomNo = '"+roomNo+"'";
    PreparedStatement ps = DB.con.prepareStatement(query);
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"Record Deleted");
           }
           
         }
         else{
                    String query ="delete from room where roomNo = '"+roomNo+"'";
    PreparedStatement ps = DB.con.prepareStatement(query);
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"Record Deleted");
        
   
    }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,""+e);
    
    }
}

    static void updateById(int id,Room r) {
       try{
           String query = "update room set roomNo=?, category = ? where roomNo= ?";
           PreparedStatement ps = DB.con.prepareStatement(query);
           ps.setInt(1, r.getRoomNo());
           ps.setString(2, r.getCategory());
           ps.setInt(3, id);
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Record Updated.");
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,""+e);
       }
    }
}