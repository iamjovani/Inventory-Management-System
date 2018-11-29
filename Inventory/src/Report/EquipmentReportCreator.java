/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;
import Equipment.Equipment;
import inventory.MySqlConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Jovani
 */
public class EquipmentReportCreator implements ReportCreatorFactory
{

    
    public EquipmentReportCreator()
    {
        
    }
    
    @Override
    public void genReport() 
    {
        
        try {
            //File filename = new File("C:/NewExcelFile.xls");
            String filename = "C:/Users/Jovani/Documents/NetBeansProjects/Inventory/EquipmentReport.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet"); 
            
            MySqlConnection conn = new MySqlConnection();
            String sql="SELECT * FROM equipment";
            ResultSet rs = conn.searchQuery(sql);
            ArrayList<Equipment> reportList = new ArrayList<Equipment>();
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
                String i = rs.getString(9);
                String j = rs.getString(10);
                String k = rs.getString(11);
                String l = rs.getString(12);
                String m = rs.getString(13);
               
                
                Equipment eq = new Equipment(b, c, d, e, f, g, h, i, j, k, l, m);
                eq.setID(a);
                
                reportList.add(eq);
            }
            //-------------------------------------------------
            
            for(int i = 0; i < reportList.size(); i++)
            {
                
                HSSFRow rowhead = sheet.createRow((short)0);
                rowhead.createCell(0).setCellValue("ID");
                rowhead.createCell(1).setCellValue("Manufacturer");
                rowhead.createCell(2).setCellValue("Model");
                rowhead.createCell(3).setCellValue("ServiceTAG");
                rowhead.createCell(4).setCellValue("memory");
                rowhead.createCell(5).setCellValue("Harddrive");
                rowhead.createCell(6).setCellValue("Location");
                rowhead.createCell(7).setCellValue("Shipped Date");
                rowhead.createCell(8).setCellValue("Warranty End Date");
                rowhead.createCell(9).setCellValue("User ID");
                rowhead.createCell(10).setCellValue("Username");
                rowhead.createCell(11).setCellValue("UWI Assest TAG");
                rowhead.createCell(12).setCellValue("HostName");

                HSSFRow row = sheet.createRow((short)i+1);
                row.createCell(0).setCellValue(reportList.get(i).getID());
                row.createCell(1).setCellValue(reportList.get(i).getManufacturer());
                row.createCell(2).setCellValue(reportList.get(i).getModel());
                row.createCell(3).setCellValue(reportList.get(i).getServiceTag());
                row.createCell(4).setCellValue(reportList.get(i).getMemory());
                row.createCell(5).setCellValue(reportList.get(i).getHarddrive());
                row.createCell(6).setCellValue(reportList.get(i).getLocation());
                row.createCell(7).setCellValue(reportList.get(i).getShippedDate());
                row.createCell(8).setCellValue(reportList.get(i).getWarrantyEndDate());
                row.createCell(9).setCellValue(reportList.get(i).getUserID());
                row.createCell(10).setCellValue(reportList.get(i).getUsersName());
                row.createCell(11).setCellValue(reportList.get(i).getUWIAssetTAG());
                row.createCell(12).setCellValue(reportList.get(i).getHostname());
                
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
