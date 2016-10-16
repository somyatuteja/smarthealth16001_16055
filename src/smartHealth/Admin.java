package smartHealth;


import java.sql.*;
public class Admin extends User{
    //\private int cno;
    //private String Qualification;
	 private String phone;
     Admin(String username,String password,String fname, String lname, String email1,String email2, String photo1, String photo2, String photo3, String aboutme, String phone,String streetname, String streetnumber, String pa, String mun, String usertype, String district)
    {
        super(username, password, fname, lname, email1, 
        		email2, photo1,  photo2,  photo3, aboutme,
        		streetname,  streetnumber,  pa,  mun,  usertype,  district);
        this.phone=phone;
    }
    /* String getUsername()
    {
        return username;
    }
     void updateCno(int c)
     {
         this.cno=c;
     }
     void updateQual(String qual)
     {
         this.Qualification=qual;
     
     }*/
      @Override
     public String toString()
    {
        String s=super.toString();
        StringBuilder st=new StringBuilder();
        st.append(s).append(System.getProperty("line.separator")).append(" phone no: ").append(this.phone);
        s=st.toString();
        return s;
        
    }
      String getPhone()
      {
    	  return this.phone;
      }
   /*   void addAdmin(){
         	super.addPerson();
         	        	

}*/
      }
