/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Galileo
 *
 */
public class StaticDate {
    
    /***********************************************DATE PARSERS*****************************************************/

    /**
     * Returns a string representation Today's Date in the format of MM/dd/yyy.
     * MM   - 2 digit representation of the Month of the year eg, 02
     * dd   - 2 digit representation of the day of the Month, eg, 09
     * yyyy - 4 digit representation year, eg 1982
     *
     * @return a string representation of the of today's date.
     */
    public static String today(){
        Calendar today  = Calendar.getInstance();


        today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH) , today.get(Calendar.DAY_OF_MONTH), 23, 59, 59);


        String dateStr = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime());

        return dateStr;
    }

    /**
     * Returns a date corresponding to n days before today's date
     * Please note, if n is a negative number the result will be n days after today
     *
     * @param numOfDays the number of days before today
     *
     * @return          the date corresponding to numOfDays before today.
     */
    public static Date dateBeforeToday(int numOfDays){
        Calendar today  = Calendar.getInstance();


        today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH) , today.get(Calendar.DAY_OF_MONTH) - numOfDays, 23, 59, 59);

        return today.getTime();
    }

    /**
     * Returns an integer representation of the current year
     *
     * @return          an integer representation of the current year
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Returns a date corresponding to n days after the given date
     * Please note, if n is a negative number the result will be n days before the given date
     *
     * @param date      the subject date that you want to project from
     * @param numOfDays the number of days after the given date
     *
     * @return          the date corresponding to numOfDays before today.
     */
    public static Date fromDate(Date date, int numOfDays) {

        return new Date(date.getTime()+ (1000 * 60 * 60 * 24 * numOfDays));
    }

    /**
     * Returns a date corresponding to n days after the given date
     * Please note, if n is a negative number the result will be n days before the given date
     *
     * @param dateStr   a string representation of the date to be converted
     * @param format    the format that the current date string is in
     *
     * @return          the parsed date object corresponding to the given date string.
     * @see             java.text.SimpleDateFormat
     */
    public static Date stringToDate(String dateStr, String format) {
        try {
            Date date = new SimpleDateFormat(format, Locale.ENGLISH)
                    .parse(dateStr);

            return date;

        } catch (java.text.ParseException e) {
            
            //e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a date corresponding to n days after the given date
     * Please note, if n is a negative number the result will be n days before the given date
     *
     * @param date      the date to be converted to a string representation
     * @param format    the format that the date string is to be converted to
     *
     * @return          the formatted string corresponding to the given date object.
     * @see             java.text.SimpleDateFormat
     */
    public static String dateToString(Date date, String format) {

        String dateStr = new SimpleDateFormat(format, Locale.ENGLISH).format(date);

        return dateStr;
    }
    
}
