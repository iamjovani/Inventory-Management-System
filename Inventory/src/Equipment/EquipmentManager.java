/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipment;

//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.toedter.calendar.JDateChooser;
import inventory.MySqlConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Properties;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Locale;

import javax.*;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jovani
 */
public class EquipmentManager{
    
    
    private static ArrayList<Equipment> EquipmentList;
    //private MySqlConnection conn = new MySqlConnection();
 
    
  
   public static void addItem(Equipment E) throws SQLException   
    {
            
           String sql = "INSERT INTO equipment(id,manufacturer,model,servicetag,memory,harddrive,location,shippeddate,warrantyenddate,userid,usersname,uwiassettag,hostname) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
 
        
            MySqlConnection conn  = new MySqlConnection();
            PreparedStatement pstmt = conn.getConnection().prepareStatement(sql);
            
        
            pstmt.setInt(1, 0);
            pstmt.setString(2, E.getManufacturer());
            pstmt.setString(3, E.getModel());
            pstmt.setString(4, E.getServiceTag());
            pstmt.setString(5, E.getMemory());
            pstmt.setString(6, E.getHarddrive());
            pstmt.setString(7, E.getLocation());
            pstmt.setString(8, E.getShippedDate());
            pstmt.setString(9, E.getWarrantyEndDate());
            pstmt.setString(10, E.getUserID());
            pstmt.setString(11, E.getUsersName());
            pstmt.setString(12, E.getUWIAssetTAG());
            pstmt.setString(13, E.getHostname());
            pstmt.executeUpdate();
        
    } 
        
    
  
    
       public static JTable showTable(JTable table) throws SQLException
    {
        MySqlConnection conn = new MySqlConnection();
        
       
            String sql="SELECT * FROM equipment";
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
                String i = rs.getString(9);
                String j = rs.getString(10);
                String k = rs.getString(11);
                String l = rs.getString(12);
                String m = rs.getString(13);
               
                
                Equipment eq = new Equipment(b, c, d, e, f, g, h, i, j, k, l, m);
                
                eq.setID(a);
                
                //EquipmentList.add(eq);
                
                model.addRow(new Object[]{eq.getID(), b, c, d, e, f, g , h, i , j, k, l, m});
                
            }
        
       
        return table;
    }
    
    
   
    
    public static JTable checkEquipment(String search, JTable table) throws NullPointerException, SQLException
    {
        
            MySqlConnection conn = new MySqlConnection();
            ArrayList<Equipment> searchList = new ArrayList<>();
            ArrayList<Equipment> resultList = new ArrayList<>();
            
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
                String i = rs.getString(9);
                String j = rs.getString(10);
                String k = rs.getString(11);
                String l = rs.getString(12);
                String m = rs.getString(13);
               
                
                Equipment eq = new Equipment(b, c, d, e, f, g, h, i, j, k, l, m);
                eq.setID(a);
                
                searchList.add(eq); 
            }
            
            
            for (Equipment item : searchList)
            {
                if (item.getManufacturer().compareToIgnoreCase(search) == 0)
                {
                    model.setRowCount(0); 
                    resultList.add(item);
                }
            }
            
            
           for (Equipment result : resultList)
               model.addRow(new Object[]{result.getID(),result.getManufacturer(),
                             result.getModel(), result.getServiceTag(),
                             result.getMemory(), result.getHarddrive(), 
                             result.getLocation(),result.getShippedDate() ,
                             result.getWarrantyEndDate(), result.getUserID(),
                             result.getUsersName(), result.getUWIAssetTAG()});
        
       return table; 
    }
    
    
    
    public void warrantyAlertDept(String WarrantyEndDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        formatter = formatter.withLocale(Locale.US);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate futureDate = LocalDate.parse(WarrantyEndDate, formatter); // WarrantyEndDate
        // WarrantyEndDate has to be entered in this format, eg. "2017-Nov-30"
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        //add 1 week to the current date
        LocalDate next1Week = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + next1Week);
        
        //SendMail mail = new SendMail();
        
        if(futureDate.equals(next1Week)){
            //return true;
            //System.out.println("True");
            //sendMail();
        }
    }
    
   
    /*
     public void sendMail(){
                final String username = "caihruwi03@gmail.com";
		final String password = "curin.08";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                //props.put("mail.smtp.starttls.enable","true");
                props.put("mail.smtp.ssl.trust","*");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("alertingcaihr@gmail.com"));
			//message.setRecipients(Message.RecipientType.TO,
			//	InternetAddress.parse("frenchchevaul@gmail.com"));
                        message.addRecipients(Message.RecipientType.BCC, 
                      InternetAddress.parse("barneszaruya@gmail.com,barnesrushane@hotmail.com"));
			message.setSubject("Equipment Alert");
			message.setText("Attention!"
				+ "\n\n Your equipment"
                                + "is approaching its warranty expiration date");

			Transport.send(message);

			System.out.println("Email sent successfully");

		} 
                catch (Exception e) 
                {
			throw new RuntimeException(e);
		}
    }
    
    
*/
    
    

    
    public static void removeEquipment(String id) throws SQLException
    {
    
        
            String sql = "DELETE FROM equipment WHERE id = ?";
            MySqlConnection conn  = new MySqlConnection();
            PreparedStatement pstmt = conn.getConnection().prepareStatement(sql);
            
            
           int idn = Integer.parseInt(id.substring(5));
            
           pstmt.setInt(1, idn);
           pstmt.executeUpdate();
 
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
    
    public static void resetPanel(ArrayList<JTextField> textField, 
                                  ArrayList<JDateChooser> dateChooser)
    {
        
       textField.forEach((fields) -> {fields.setText(""); });
        
        
       dateChooser.forEach((chooser) -> { chooser.setDate(null); });
        
        
    }
    
    public static void updateRecord(Equipment E, String id) throws SQLException
    {
          
        int idn = Integer.parseInt(id.substring(5));
        String sql = "UPDATE equipment SET manufacturer=?,model=?,servicetag=?,memory=?,harddrive=?,location=?,shippeddate=?,warrantyenddate=?,userid=?,usersname=?,uwiassettag=?,hostname=? WHERE id="+idn;
 
        
        MySqlConnection conn  = new MySqlConnection();
        PreparedStatement pstmt = conn.getConnection().prepareStatement(sql);
            
                
        pstmt.setString(1, E.getManufacturer());
        pstmt.setString(2, E.getModel());
        pstmt.setString(3, E.getServiceTag());
        pstmt.setString(4, E.getMemory());
        pstmt.setString(5, E.getHarddrive());
        pstmt.setString(6, E.getLocation());
        pstmt.setString(7, E.getShippedDate());
        pstmt.setString(8, E.getWarrantyEndDate());
        pstmt.setString(9, E.getUserID());
        pstmt.setString(10, E.getUsersName());
        pstmt.setString(11, E.getUWIAssetTAG());
        pstmt.setString(12, E.getHostname());
        pstmt.executeUpdate();
            
    }  
    
    
    
      public static JTable searchServiceTAG(String search, JTable table) throws NullPointerException, SQLException
    {
        
            MySqlConnection conn = new MySqlConnection();
            ArrayList<Equipment> searchList = new ArrayList<>();
            ArrayList<Equipment> resultList = new ArrayList<>();
            
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
                String i = rs.getString(9);
                String j = rs.getString(10);
                String k = rs.getString(11);
                String l = rs.getString(12);
                String m = rs.getString(13);
               
                
                Equipment eq = new Equipment(b, c, d, e, f, g, h, i, j, k, l, m);
                eq.setID(a);
                
                searchList.add(eq); 
            }
            
            
            for (Equipment item : searchList)
            {
                if (item.getServiceTag().compareToIgnoreCase(search) == 0)
                {
                    model.setRowCount(0); 
                    resultList.add(item);
                }
            }
            
            
           for (Equipment result : resultList)
               model.addRow(new Object[]{result.getID(),result.getManufacturer(),
                             result.getModel(), result.getServiceTag(),
                             result.getMemory(), result.getHarddrive(), 
                             result.getLocation(),result.getShippedDate() ,
                             result.getWarrantyEndDate(), result.getUserID(),
                             result.getUsersName(), result.getUWIAssetTAG()});
        
       return table; 
    }
   
    
    
}
