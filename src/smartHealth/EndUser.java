package smartHealth;
//class for End Users
import java.sql.*;
import java.util.*;

public class EndUser extends User {
	private String createdate;
	private int karma;
	
    EndUser(String username,String password,String fname, String lname, String email1,
    		String email2, String photo1, String photo2, String photo3, String aboutme,String streetname,
    		String streetnumber, String pa, String mun, String usertype, String district)
    {
       super(username, password, fname, lname, email1, email2, photo1,  photo2,  photo3, aboutme,streetname,  streetnumber,  pa,  mun,  usertype,  district);
       this.karma=0;
       
       java.util.Date dt = new  java.util.Date();
      
   	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
   	this.createdate= sdf.format(dt);
   	//System.out.println(this.createdate);
    }
    
   
        @Override
     public String toString()
    {
        String s=super.toString();
        StringBuilder st=new StringBuilder();
        st.append(s).append(System.getProperty("line.separator")).append(" karma: ").append(this.karma);
        s=st.toString();
        return s;
        
    }
       //returns the value of karma
        
        int getKarma()
        {
        	return this.karma;
        	
        }
        
        //returns the creation date for the end user's profile
        String getCreateDate()
        {
        	return this.createdate;
        }
    
      /*  void addEndUser(){
        	super.addPerson();
        	        	
        			
        }*/
        
    
    }    

