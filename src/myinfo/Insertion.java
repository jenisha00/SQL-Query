
package myinfo;

/**
 *
 * @author Jenisha Munikar
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class Insertion {

    public static void main(String[] args) {
    
       Database databaseManager = new Database( "root", "" ); 
       Calendar calendar = Calendar.getInstance();
       java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        String query = " insert into info(User_name,Email,Address,Contact)"
        + " values (?,?, ?, ?)";

      PreparedStatement preparedStmt = null;
        try {
            preparedStmt = databaseManager.getConection().prepareStatement(query);
            preparedStmt.setString (1, "Wan Rai");
            preparedStmt.setString (2, "wan000@gmail.com");
            preparedStmt.setString(3,"Naxal");
            preparedStmt.setString(4,"9812345672");
            int i=preparedStmt.executeUpdate();
            System.out.println(i+" record inserted");
            preparedStmt.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Insertion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
}
    
