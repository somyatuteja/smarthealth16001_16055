package smartHealth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Moderator extends User{
	
	private String cno;
     Moderator(String username,String password,String fname, String lname,String email1,String email2, String photo1, 
    		 String photo2, String photo3, String aboutme,String streetname, String streetnumber, String pa,
    		 String mun, String usertype, String district, String cno)
    {
        super(username, password, fname, lname, email1, email2, photo1,  photo2,  photo3, aboutme,streetname,  
        		streetnumber,  pa,  mun,  usertype,  district);
        this.cno=cno;
        
    }
     String getPhone()
    {
        return this.cno;
    }
       public String toString()
    {
        String s=super.toString();
        StringBuilder st=new StringBuilder();
        s=st.toString();
        return s;
        
    } 
   
}