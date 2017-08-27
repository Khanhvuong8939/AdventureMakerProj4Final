
package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;



public class test {
    
//    static String date = "15/08/2017 08:00:00";
    
    public static void main(String[] args) {
        String target = "08-12-2017 11:20:59";
    DateFormat df = new SimpleDateFormat("MM-dd-yyyy kk:mm:ss");
    Date result = new Date();  
        try {
            result = df.parse(target);
        } catch (ParseException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println(result);
        
    }

}
