package smartHealth;
//the database connectivity is done in this class
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionToDB {
	 private static ConnectionToDB conInstance;
	    private static Connection con ;
	    
	private ConnectionToDB() {
	      // private constructor 
	    }
//singleton class: static instance is created. The connection will be done once in every session
	    public static ConnectionToDB getInstance(){
	    if(conInstance==null){
	        conInstance= new ConnectionToDB();
	    }
	    return conInstance;
	    }
//the connection variable is getting initialized in this function and it is returned to the calling function
	    public  Connection getConnection(){

	        if(con==null){
	            try {
	            	try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                String host = "jdbc:mysql://localhost:3306/smarthealthdb?user=root&password=somya";
	               
	                con = DriverManager.getConnection( host);
	            } catch (SQLException ex) {
	               ex.printStackTrace();
	            }
	        }

	        return con;
	    }
}
