/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equipment;

import java.sql.Date;

/**
 *
 * @author Jovani
 */
public class Equipment
{
    private int count;
    private String ID;
    private String Manufacturer;
    private String Model;
    private String ServiceTag;
    private String Memory;
    private String Harddrive;
    private String Location;
    private String UsersName;
    private String UserID;
    private String UWIAssetTAG;
    private String ShippedDate;
    private String WarrantyEndDate;
    private String Hostname;
 

    public Equipment(String Manufacturer, String Model, String ServiceTag, 
                     String Memory, String Harddrive, String Location, 
                     String ShippedDate, String WarrantyEndDate, String UserID, 
                     String UsersName, String UWIAssetTAG, String Hostname) 
    {
        
        this.Manufacturer = Manufacturer;
        this.Memory = Memory;
        this.Model = Model;
        this.Harddrive = Harddrive;
        this.ServiceTag = ServiceTag;
        this.Location = Location;
        this.ShippedDate = ShippedDate;
        this.WarrantyEndDate = WarrantyEndDate;
        this.UserID = UserID;
        this.UsersName = UsersName;
        this.UWIAssetTAG = UWIAssetTAG;
        this.Hostname = Hostname;
        
       
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getUsersName() {
        return UsersName;
    }

    public String getUserID() {
        return UserID;
    }

    public String getUWIAssetTAG() {
        return UWIAssetTAG;
    }

    public String getShippedDate() {
        return ShippedDate;
    }

    public String getWarrantyEndDate() {
        return WarrantyEndDate;
    }

    public void setServiceTag(String ServiceTag) {
        this.ServiceTag = ServiceTag;
    }

    public void setMemory(String Memory) {
        this.Memory = Memory;
    }

    public void setHarddrive(String Harddrive) {
        this.Harddrive = Harddrive;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
    
    /*
    public void setCount(int count) {
        Equipment.count += count;
    }
*/
    public void setID(int ID) {
        this.ID = (Location.substring(0, 1) + Location.substring(2, 3)).toUpperCase() 
              + String.format("%04d", ID);
    }
  
    
      

    public String getManufacturer() 
    {
        return Manufacturer;
    }

    public String getModel() 
    {
        return Model;
    }

    public String getServiceTag() 
    {
        return ServiceTag;
    }

    public String getMemory() 
    {
        return Memory;
    }

    public String getHarddrive() 
    {
        return Harddrive;
    }

    public String getLocation() 
    {
        return Location;
    }

    public String getHostname() {
        return Hostname;
    }
    
    public String getID()
    {
        return this.ID;
    }  
    
}
