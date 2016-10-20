package eventsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucía Batista Flores
 */
public class ConnectionToData {
    
    Connection c;
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/eventsystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lucia";
    
    public  ConnectionToData(){
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try{
                c=DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            }catch(SQLException e){
                System.out.print(e.getMessage());
           //     e.printStackTrace();
            }
        }catch(ClassNotFoundException ex){
            System.out.print("Driver Not Found");
        }
    }

    public Connection getConnectionToData() {
        return c;
    }
    
    public void InsertQuery(String sql) throws SQLException, ClassNotFoundException{
       
        ConnectionToData con= new ConnectionToData();
        Statement stmt = con.getConnectionToData().createStatement();
        stmt.executeUpdate(sql);
      //  stmt.close();
    }
    
    public ResultSet GetData(String sql) throws SQLException, ClassNotFoundException{
       
        
        ConnectionToData con= new ConnectionToData();
        Statement stmt = con.getConnectionToData().createStatement();
        ResultSet r=stmt.executeQuery(sql);
      //  System.out.print(r);
        return r;
    }
    
    public void close() throws SQLException{
        c.close();
    }
    
}
