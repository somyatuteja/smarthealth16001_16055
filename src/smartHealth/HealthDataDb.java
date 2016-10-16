package smartHealth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HealthDataDb {
	void showProperty()
	{	try {
	Connection con= ConnectionToDB.getInstance().getConnection();
	PreparedStatement ps;
	String sqlget="select * from property";
	ps=con.prepareStatement(sqlget);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		System.out.println("Press "+rs.getInt("propertyid")+"for "+rs.getString("name"));
	}}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
   void getLastDatumID()
	{
	   try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			String sqlget="select max(datumid) from datum";
			String sqlget1="select max(forumid) from forum";
			ps=con.prepareStatement(sqlget);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			HealthData.id=rs.getInt("max(datumid)");
			ps=con.prepareStatement(sqlget1);
			 rs=ps.executeQuery();
			if(rs.next())
			Forum.lastforumid=rs.getInt(1);
	   }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}
	
	void setHealthDataToDatabase(HealthData h )

	{
		Connection con = ConnectionToDB.getInstance().getConnection();
		 PreparedStatement ps;
		 String sqlq="insert into datum values("+h.getDatumid()+",'"+h.getUsername()+"',"+h.getProperty()+",'"+h.getValue()+"','"+h.getDateset()+"')";
			
			try {
				ps=con.prepareStatement(sqlq);
				ps.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	

	}
	void showHealthData(String uname)

	{	try {
	Connection con= ConnectionToDB.getInstance().getConnection();
	PreparedStatement ps;
	String sqlget="select * from datum where username='"+uname+"'";
	ps=con.prepareStatement(sqlget);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		System.out.println(" Date :"+rs.getString("whensaved")+" Property : "+rs.getString("propertyid")+" value :"+ rs.getString("value"));

	}}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	boolean checkFriendship(String uname, String fname)
	{
		try {
	Connection con= ConnectionToDB.getInstance().getConnection();
	PreparedStatement ps;
	String sqlget="select * from friendship where requester_username='"+uname+"'";
	ps=con.prepareStatement(sqlget);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
	if((rs.getString("whenconfirmed")!=null)&&(rs.getString("whenunfriended")==null))
	{
		if(rs.getString("requested_username").equals(fname))
			return true;
	}
	}
	}
	catch (SQLException e) {
	e.printStackTrace();
	}	
    try {
	Connection con= ConnectionToDB.getInstance().getConnection();
	PreparedStatement ps;
	String sqlget="select * from friendship where requested_username='"+uname+"'";
	ps=con.prepareStatement(sqlget);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
	if((rs.getString("whenconfirmed")!=null)&&(rs.getString("whenunfriended")==null))
	{
		if(rs.getString("requester_username").equals(fname))
			return true;
	}
	}}
	catch (SQLException e) {
	e.printStackTrace();
	}	
		return false;
	}


}
