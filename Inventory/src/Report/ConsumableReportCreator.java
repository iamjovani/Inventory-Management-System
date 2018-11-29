/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import Consumable.Consumable;
import inventory.MySqlConnection;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Jovani
 */
public class ConsumableReportCreator  implements ReportCreatorFactory
{
    public ConsumableReportCreator()
    {
        
    }

    @Override
    public void genReport() 
    {
       try {
           
            String filename = "C:/Users/Jovani/Documents/NetBeansProjects/Inventory/ConsumableReport.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet"); 
            
            MySqlConnection conn = new MySqlConnection();
            String sql="SELECT * FROM consumable";
            ResultSet rs = conn.searchQuery(sql);
            ArrayList<Consumable> reportList = new ArrayList<Consumable>();
            //-------------------------------------------------
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
                
                reportList.add(cn);
            }
            //-------------------------------------------------
            
            
            
            for(int i = 0; i < reportList.size(); i++)
            {
                
                HSSFRow rowhead = sheet.createRow((short)0);
                rowhead.createCell(0).setCellValue("ID");
                rowhead.createCell(1).setCellValue("Name");
                rowhead.createCell(2).setCellValue("Manufacturer");
                rowhead.createCell(3).setCellValue("Size");
                rowhead.createCell(4).setCellValue("Expiration Date");
                rowhead.createCell(5).setCellValue("Location");
                rowhead.createCell(6).setCellValue("Size");
                rowhead.createCell(7).setCellValue("Quantity");
            

                HSSFRow row = sheet.createRow((short)i+1);
                row.createCell(0).setCellValue(reportList.get(i).getID());
                row.createCell(1).setCellValue(reportList.get(i).getName());
                row.createCell(2).setCellValue(reportList.get(i).getManufacturer());
                row.createCell(3).setCellValue(reportList.get(i).getSize());
                row.createCell(4).setCellValue(reportList.get(i).getExpDate());
                row.createCell(5).setCellValue(reportList.get(i).getLocation());
                row.createCell(6).setCellValue(reportList.get(i).getType());
                row.createCell(7).setCellValue(reportList.get(i).getQuantity());
            
                
            }

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");

        } catch ( Exception ex ) {
            System.out.println(ex);
        }
    }
}
   