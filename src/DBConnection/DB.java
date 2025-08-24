/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;


import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author Asif Hussain
 */
public class DB {
    public static Connection con =null;
    
    public static void loadConnection(){
    String url ="jdbc:mysql://localhost:3306/hospital";
    String root="root";
    String pass ="";
    
    try{
        con = DriverManager.getConnection(url,root,pass);
        if(con!=null){
        JOptionPane.showMessageDialog(null,"Connected");
       
        }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error"+e);
    }
    
    
}
}
