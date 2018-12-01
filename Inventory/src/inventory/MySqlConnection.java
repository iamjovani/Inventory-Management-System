/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jovani
 */
public class MySqlConnection {
    
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    //private PreparedStatement pst;
    
    
    public Connection getConnection()
    {
        
        try 
        {
            String url = "jdbc:mysql://localhost/test";
            String user = "root";
            String pass = "";
            
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            //JOptionPane.showMessageDialog(null, "Connected to database");
        } 
         catch (SQLException e)
        {
            //JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Unable to Connect to Database!");
        }
        
        catch (ClassNotFoundException e)
        {
            //JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Unable to Connect to Database!");
        }
        
        catch (Exception e)
        {
             //JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Unable to Connect to Database!");
        }
        
        finally
        {
            return conn;
        }
    }
    
    public ResultSet searchQuery(String sql)
    {
        try 
        {
            getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Unable to Connect to Database!");
        }
        return rs;
    }
    
public Statement getStatement(){return st;}
    
}
