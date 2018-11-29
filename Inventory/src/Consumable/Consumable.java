/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumable;

/**
 *
 * @author Jovani
 */
public class Consumable 
{
    private int count;
    private String ID;
    private String Name;
    private String Manufacturer;
    private String Size; // string until further notice
    private String expDate;
    private String Location;
    private String Type;
    private String Quantity;
    
    public Consumable(String name, String manufacturer, String size, 
                        String expdate, String location, String type, String quantity)
    {
//        this.ID = (Location.substring(0, 1) + Location.substring(2, 3)).toUpperCase() 
//              + String.format("%04d", count);
        this.Name = name;
        this.Size = size;
        this.Manufacturer = manufacturer;
        this.expDate = expdate;
        this.Location = location;
        this.Type = type;
        this.Quantity = quantity;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public String getSize() {
        return Size;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getLocation() {
        return Location;
    }

    public String getType() {
        return Type;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
      public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
      
    public void setID(int ID) {
        this.ID = (Location.substring(0, 1) + Location.substring(2, 3)).toUpperCase() 
              + String.format("%04d", ID);
    }
}
