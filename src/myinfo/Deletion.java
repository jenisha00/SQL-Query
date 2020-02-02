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

public class Deletion {
    
    public static void main(String[] args) 
    {
       Database databaseManager = new Database( "root", "" ); 
       Calendar calendar = Calendar.getInstance();
       java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
       
       String query = " delete from info where id=?";
       
       PreparedStatement preparedStmt=null;
       try{
        preparedStmt = databaseManager.getConection().prepareStatement(query);
        preparedStmt.setInt(1,106);
        int i=preparedStmt.executeUpdate();
        System.out.println(i+" record deleted");
        preparedStmt.close();
       }
       catch (SQLException ex) {
        Logger.getLogger(Deletion.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
}
