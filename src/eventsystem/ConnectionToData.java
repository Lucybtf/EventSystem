package eventsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucía Batista Flores
 */
public class ConnectionToData {
    //private static final String DATA
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/EventSystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public ConnectionToData(){
        Connection c= null;
        try{
            c=DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }
    }
}
