/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author Jovani
 */
public class ReportFactory 
{
    public ReportFactory()
    {
        
    }
    
    public void getReport(String report)
    {
        
        if(report.compareToIgnoreCase("Consumable") == 0)
            new ConsumableReportCreator().genReport();
        
        if(report.compareToIgnoreCase("Equipment") == 0)
            new EquipmentReportCreator().genReport();
    }
}
