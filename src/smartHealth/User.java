package smartHealth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class User {
	private String username;
   private String password;
   private String fname;
   private String lname;
   private String email1;
   private String email2;
   private String photo1;
   private String photo2;
   private String photo3;
   private String aboutme;
   private String streetnumber;
   private String streetname;
   private String municipality;
   private String district;
   private String postalarea;
   private String usertype;
   private boolean status;
   
   User(String username,String password,String fname, String lname, String email1,String email2, String photo1, String photo2,
    		String photo3, String aboutme, String streetname, String streetnumber, String pa, String mun,String usertype, String district)
   {
       this.username=username;
     this.aboutme=aboutme; 
     this.email1=email1;
     this.fname=fname;
     this.lname=lname;
     this.password=password;
     this.photo1=photo1;
     this.photo2=photo2;
     this.photo3=photo3;
     this.email2=email2;
     this.streetname=streetname;
     this.streetnumber=streetnumber;
     this.municipality=mun;
     this.postalarea=pa;
     this.usertype=usertype;
     this.district=district;
     this.status=true;
   }
   User()
   {
	   
   }
    @Override
    public String toString()
    {
        StringBuilder s=new StringBuilder();
        s.append("Username : ").append(this.username).append("\r\n Password : ").append(this.password).append("\r\n Name : ").append(this.fname).
        append(" ").append(this.lname).append("\r\n Address : ").append(this.streetnumber).append(this.streetname).append(this.municipality).
        append(this.district).append(this.postalarea).append("\n Primary email : ").append(this.email1).append("\n Secondary email : ").
        append(this.email2).append(" \n About Me : " ).append(this.aboutme);
                return s.toString();
    }
    
 /* void addPerson()

    {
    	Connection con;
    	PreparedStatement ps;
    	try {
    		String sqlq="insert into user values('"+this.username+"','"+this.password+"','"+this.email1+"','"+this.email2+"','"+this.fname+"','"+this.lname
    				+"','"+this.aboutme+"','"+this.photo1+"','"+this.photo2+"','"+this.photo3+"','"+this.streetnumber+"','"+this.streetname+"','"+this.municipality+"','"
    				+this.district+"','"+this.postalarea+"',(select usertypeid from usertype where usertypeid=3),true)";
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smarthealthdb?user=root&password=somya");
			ps=con.prepareStatement(sqlq);
			/*ps.setString(1, this.username);
			ps.setString(2, this.password);
			ps.setString(3, this.email1);
			ps.setString(4, this.email2);
			ps.setString(5, this.fname);
			ps.setString(6, this.lname);
			ps.setString(7, this.aboutme);
			ps.setString(8, this.photo1);
			ps.setString(9, this.photo2);
			ps.setString(10, this.photo3);
			ps.setString(11, this.streetnumber);
			ps.setString(12, this.streetname);
			ps.setString(13, this.municipality);
			ps.setString(14, this.district);
			ps.setString(15, this.postalarea);
			ps.setString(16,"(select usertypeid from usertype where usertypeid=3)" );
		ps.setBoolean(17, true);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    }*/

public String getUsername()
{
	return this.username;
}
public String getPassword()
{
	return this.password;
}
public String getUsertype() {
	return usertype;
}
public String getFirstName()
{
	return this.fname;
}
public String getLastName()
{
	return this.lname;
}
public boolean getStatus() {
	return status;
}
public String getEmail1()
{
	return this.email1;
}
public String getEmail2()
{
	return this.email2;
}
public String getAboutMe()
{
	return this.aboutme;
}
public String getPic1()
{
	return this.photo1;
}
public String getPic2()
{
	return this.photo2;
}
public String getPic3()
{
	return this.photo3;
}
public String getStreetName()
{
	return this.streetname;
}
public String getStreetNumber()
{
	return this.streetnumber;
}
public String getDistrict()
{
	return this.district;
}
public String getMunicipality()
{
	return this.municipality;
}
public String getPostalArea()
{
	return this.postalarea;
			
}

}

