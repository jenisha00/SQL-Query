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

public class Update {
    public static void main(String[] args)
    {
       Database databaseManager = new Database( "root", "" ); 
       Calendar calendar = Calendar.getInstance();
       java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
       
       String query = " update info set Contact=?,Address=? where id=?";
       
       PreparedStatement preparedStmt= null;
       try{
        preparedStmt = databaseManager.getConection().prepareStatement(query);
        preparedStmt.setString(1,"9840002245");
        preparedStmt.setString(2,"Siphal");
        preparedStmt.setInt(3,104);
        int i= preparedStmt.executeUpdate();
        System.out.println(i+" record updated");
        preparedStmt.close();
       }
       catch (SQLException ex) {
        Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
}
