package myinfo;

/**
 *
 * @author Jenisha Munikar
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Selection {
    
    public static void main(String[] args)
    {
        Database databaseManager = new Database( "root", "" ); 
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        
        String query = "select * from info";
        PreparedStatement preparedStmt=null;
        try {
            preparedStmt = databaseManager.getConection().prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery(query);
            while(rs.next()){ 
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "
                +rs.getString(4)+" "+rs.getString(5));
            } 
            rs.close();
       }
       catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
}
