/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumable;

import com.toedter.calendar.JDateChooser;
import inventory.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jovani
 */
public class ConsumableManager 
{
    public static void addItem(Consumable C) throws SQLException   
    {
            
           String sql = "INSERT INTO consumable(id,name,manufacturer,size,expdate,location,type,quantity) VALUES(?,?,?,?,?,?,?,?)";
 
        
            MySqlConnection conn  = new MySqlConnection();
            PreparedStatement pstmt = conn.getConnection().prepareStatement(sql);
            
            pstmt.setInt(1, 0);
            pstmt.setString(2, C.getName());
            pstmt.setString(3, C.getManufacturer());
            pstmt.setString(4, C.getSize());
            pstmt.setString(5, C.getExpDate());
            pstmt.setString(6, C.getLocation());
            pstmt.setString(7, C.getType());
            pstmt.setString(8, C.getQuantity());
            pstmt.executeUpdate();
        
    } 
    
    
    
           public static JTable showTable(JTable table) throws SQLException
    {
        MySqlConnection conn = new MySqlConnection();
        
       
            String sql="SELECT * FROM consumable";
            ResultSet rs = conn.searchQuery(sql);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
        
            while(rs.next())
            {
                
                int a = rs.getInt(1);
                String b = rs.getString(2);
                String c = rs.getString(3);
                String d = rs.getString(4);
                String e = rs.getString(5);
                String f = rs.getString(6);
                String g = rs.getString(7);
                String h = rs.getString(8);
               
                
                Consumable cn = new Consumable(b, c, d, e, f, g, h);
                
                cn.setID(a);
                
                model.addRow(new Object[]{cn.getID(), b, c, d, e, f, g , h});
                
            }
        
       
        return table;
    }
      
           
     public static boolean checkPanel(ArrayList<JTextField> textField, 
                                     ArrayList<JDateChooser> dateChooser)
    {
        boolean allFieldsFilled = true;
        
       for (JTextField fields : textField)
       {
           if ((fields.getText()).equalsIgnoreCase(""))
                   allFieldsFilled = false;
       }
       
       for (JDateChooser dates : dateChooser)
       {
           if ((dates.getDate()) == null)
               allFieldsFilled = false;
       }
        
        return allFieldsFilled;
    }
           
        public static JTable searchManufacturer(String search, JTable table) throws NullPointerException, SQLException
    {
        
            MySqlConnection conn = new MySqlConnection();
            ArrayList<Consumable> searchList = new ArrayList<>();
            ArrayList<Consumable> resultList = new ArrayList<>();
            
            String sql="SELECT * FROM equipment";
            ResultSet rs = conn.searchQuery(sql);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
        
            while(rs.next())
            {
                
                int a = rs.getInt(1);
                String b = rs.getString(2);
                String c = rs.getString(3);
                String d = rs.getString(4);
                String e = rs.getString(5);
                String f = rs.getString(6);
                String g = rs.getString(7);
                String h = rs.getString(8);
                
               
                
                Consumable cn = new Consumable(b, c, d, e, f, g, h);
                cn.setID(a);
                
                searchList.add(cn); 
            }
            
            
            for (Consumable item : searchList)
            {
                if (item.getManufacturer().compareToIgnoreCase(search) == 0)
                {
                    model.setRowCount(0); 
                    resultList.add(item);
                }
            }
            
            
           for (Consumable result : resultList)
               model.addRow(new Object[]{result.getID(),result.getName(),
                             result.getManufacturer(), result.getSize(),
                             result.getExpDate(), result.getLocation(), 
                             result.getType(),result.getQuantity(),
               });
        
       return table; 
    }
    
      public static void resetPanel(ArrayList<JTextField> textField, 
                                  ArrayList<JDateChooser> dateChooser)
    {
        
       textField.forEach((fields) -> {fields.setText(""); });
        
        
       dateChooser.forEach((chooser) -> { chooser.setDate(null); });
        
        
    }
    
     public static void removeConsumable(String id) throws SQLException
    {
    
        
            String sql = "DELETE FROM Consumable WHERE id = ?";
            MySqlConnection conn  = new MySqlConnection();
            PreparedStatement pstmt = conn.getConnection().prepareStatement(sql);
            
            
           int idn = Integer.parseInt(id.substring(5));
            
           pstmt.setInt(1, idn);
           pstmt.executeUpdate();
 
    } 
     
     public static void updateRecord(Consumable C, String id) throws SQLException
    {
          
        int idn = Integer.parseInt(id.substring(5));
        String sql = "UPDATE consumable SET name=?,manufacturer=?,size=?,expdate=?,location=?,type=?,quantity=? WHERE id="+idn;
 
        
        MySqlConnection conn  = new MySqlConnection();
        PreparedStatement pstmt = conn.getConnection().prepareStatement(sql);
            
                
        pstmt.setString(1, C.getName());
        pstmt.setString(2, C.getManufacturer());
        pstmt.setString(3, C.getSize());
        pstmt.setString(4, C.getExpDate());
        pstmt.setString(5, C.getLocation());
        pstmt.setString(6, C.getType());
        pstmt.setString(7, C.getQuantity());
        pstmt.executeUpdate();
            
    }  
}
