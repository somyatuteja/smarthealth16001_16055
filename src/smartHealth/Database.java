package smartHealth;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	//function to add new user profile
	private void addToDatabase(User u)
	{
		Connection con = ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;
		String sqlq="insert into user values('"+u.getUsername()+"','"+u.getPassword()+"','"+u.getEmail1()+"','"+u.getEmail2()+"','"+u.getFirstName()+"','"+u.getLastName()
		+"','"+u.getAboutMe()+"','"+u.getPic1()+"','"+u.getPic2()+"','"+u.getPic3()+"','"+u.getStreetNumber()+"','"+u.getStreetName()+"','"+u.getMunicipality()+"','"
		+u.getDistrict()+"','"+u.getPostalArea()+"',(select usertypeid from usertype where usertypeid=3),true)";

		try {
			ps=con.prepareStatement(sqlq);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}	
	}
	//function to add new end user profile

	void addEndUserToDatabase(EndUser eu)
	{
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			String eusqlq="insert into enduser values('"+eu.getUsername()+"',"+eu.getKarma()+",'"+eu.getCreateDate()+"')";
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();
			addToDatabase(eu);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//function to add new admin profile
	void addAdminToDatabase(Admin a)

	{
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			String asqlq="insert into enduser values('"+a.getUsername()+"','"+a.getPhone()+"')";
			ps=con.prepareStatement(asqlq);
			ps.executeUpdate();
			addToDatabase(a);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//function to add new moderator profile
	void addModeratorToDatabase(Moderator m)

	{
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;

			String mdsqlq="insert into moderator values('"+m.getUsername()+"','"+m.getPhone()+"')";

			ps=con.prepareStatement(mdsqlq);
			ps.executeUpdate();
			addToDatabase(m);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	//function to add new moderator qualification in the ModeratorQualification table
	void addModeratorQualificationToDatabase(Moderator m, int id)
	{
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String timestamp= sdf.format(dt);

			String mdsqlq="insert into moderatorqualification values("+id+",'"+m.getUsername()+"','"+timestamp+"')";

			ps=con.prepareStatement(mdsqlq);
			ps.executeUpdate();
			//addToDatabase(m);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	//function to check whether the Username and Password entered by the user during the login is valid or not
	boolean loginCheck(String u,String p)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="select password,status from user where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				rs.getString("password");
				if(p.equals(rs.getString("password")))
				{
					//if(rs.getByte(""))
					return true;	
				}}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//function to check if the username entered during registration already exists or not
	boolean checkUsername(String u)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="select * from user where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ResultSet rs=ps.executeQuery();
			if (rs.isBeforeFirst() ) { 
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//update password
	boolean checkPassword(String p){

		boolean valid=false;
		if (p.length()>15||p.length()<6){
			System.out.println("Password should be less than 15 and more than 8 characters in length");
			valid=true;

		}

		String upperCase = "(.*[A-Z].*)";
		if (!p.matches(upperCase)){
			System.out.println("Password should contain atleast one upper case letter");	
			valid=true;
		}

		String lowerCase = "(.*[a-z].*)";
		if (!p.matches(lowerCase)){
			System.out.println("Password should contain atleast one lower case letter");	
			valid=true;
		}

		return valid;

	}

	boolean checkPhone(String p){
		boolean valid=false;
		String num="[0-9]+";
		if(!p.matches(num)){
			System.out.println("Invalid phone number");
			valid=true;
		}
		return valid;
	}






	void updatePassword(String u, String p){
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set password= '"+p+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//sets the status to false only when the user deletes his profile from the system. Otherwise by default it is set to true
	void updateStatus(String u){
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set status= false where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//update secondary email
	void updateEmail2(String u, String e2){
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set email1 = '"+e2+"' where username = '"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	//update pic1
	void updatePic1(String u, String p){
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set photourl1='"+p+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//update pic2
	void updatePic2(String u, String p){
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set photourl2='"+p+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//update pic 3
	void updatePic3(String u, String p){
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set photourl3='"+p+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//update about me
	void updateAboutMe(String u, String am){
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set aboutme='"+am+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//update first name
	void updateFirstName(String u, String fn){
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set firstname='"+fn+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//update last name
	void updateLastName(String u, String ln){
		Connection con=
				ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set lastname='"+ln+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//update street name
	void updateStreetName(String u, String sn)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set streetname='"+sn+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//update street number
	void updateStreetNumber(String u, String sn)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set streetnumber='"+sn+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//update major municipality
	void updateMajorMunicipalitity(String u, String mm)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set MajorMunicipalitity='"+mm+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//update postal area
	void updatePostalArea(String u, String pa)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set PostalArea='"+pa+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//update district
	void updateDistrict(String u, String mm)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="update user set MajorMunicipalitity='"+mm+"' where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//update phone: check if the user is a moderator or admin and change accordingly
	void updatePhone(String u, String p)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;

		String eusqlq="select * from moderator where username='"+u+"'";
		try {
			ps=con.prepareStatement(eusqlq);
			ResultSet rs=ps.executeQuery();
			if (!rs.isBeforeFirst() ) {
				String msqlq="update moderator set phone='"+p+"' where username='"+u+"'";
				try {
					ps=con.prepareStatement(msqlq);
					ps.executeUpdate();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String asqlq="select * from administrator where username='"+u+"'";
		try {
			ps=con.prepareStatement(asqlq);
			ResultSet rs=ps.executeQuery();
			if (!rs.isBeforeFirst() ) { 
				String msqlq="update administrator set phone='"+p+"' where username='"+u+"'";
				try {
					ps=con.prepareStatement(msqlq);
					ps.executeUpdate();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//add friend
	void addFriendRequesttoDatabase(Friendship f )
	{	
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			String eusqlq="insert into friendship values('"+f.getRequesterUsername1()+"','"+f.getRequestedUsername2()+"','"+f.getWhenRequested()+"',null,null,null,null)";
			ps=con.prepareStatement(eusqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//qualification of moderators
	void showQualifications()
	{	try {
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;
		String sqlget="select * from qualification";
		ps=con.prepareStatement(sqlget);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Press "+rs.getInt("qualificationid")+"for "+rs.getString("description") );
		}}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

	//accept friend request
	void acceptFriendRequest(String Uname, String fname)
	{
		//f.acceptRequest();
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String whenconfirmed= sdf.format(dt);
		String fsqlq="update friendship set whenconfirmed='"+whenconfirmed+"' where requester_username='"+fname+"' and requested_username='"+Uname+"'";
		try {
			ps=con.prepareStatement(fsqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//reject friend request
	void rejectFriendRequest(String Uname, String fname)
	{
		//f.acceptRequest();
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String whenconfirmed= sdf.format(dt);
		String fsqlq="update friendship set whenrejected='"+whenconfirmed+"' where requester_username='"+fname+"' and requested_username='"+Uname+"'";
		try {
			ps=con.prepareStatement(fsqlq);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//unfriend from existing friend
	void unFriend(String uname, String fname)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String whenunfriended= sdf.format(dt);
		String fsqlq="update friendship set whenunfriended='"+whenunfriended+"' where requester_username='"+fname+"' and requested_username='"+uname+"'";
		String fsqlq1="update friendship set whenunfriended='"+whenunfriended+"' where requested_username='"+fname+"' and requester_username='"+uname+"'";
		try {
			ps=con.prepareStatement(fsqlq);
			ps.executeUpdate();
			ps=con.prepareStatement(fsqlq1);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//display the list of usernames from the user table
	void displayUsers()
	{
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			String sqlget="select username from user"
					+ "";
			ps=con.prepareStatement(sqlget);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString("username") );
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	//show the entire profile of the current user, who has logged in to his account
	void viewUserProfile(String u)
	{
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			String sqlget="select * from user where username='"+u+"'";
			ps=con.prepareStatement(sqlget);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Username:"+rs.getString("username") );
				System.out.println("Password:"+rs.getString("password") );
				System.out.println("First Name:"+rs.getString("firstname") );
				System.out.println("Last Name:"+rs.getString("lastname") );
				System.out.println("email1:"+rs.getString("email1") );
				System.out.println("email2:"+rs.getString("email2") );
				
				System.out.println("About me:"+rs.getString("aboutme") );
				System.out.println("Photo URL 1:"+rs.getString("photourl1") );
				System.out.println("Photo URL 2"+rs.getString("photourl2") );
				System.out.println("Photo URL 3"+rs.getString("photourl3") );
				System.out.println("Street Number"+rs.getString("streetnumber") );
				System.out.println("Street Name:"+rs.getString("streetname") );
				System.out.println("Major Municipality:"+rs.getString("majormunicipality") );
				System.out.println("Governing District:"+rs.getString("governingdistrict") );
				System.out.println("Postal Area:"+rs.getString("postalarea") );
				System.out.println("User Type"+rs.getString("usertypeid") );
				System.out.println("Username:"+rs.getString("username") );	
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	//selects the username of the friends of the current user
	void getFriends(String uname)
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
					System.out.println(rs.getString("requested_username"));
				}
			}}
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
					System.out.println(rs.getString("requester_username"));
				}
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	//shows list of friend request received by the current user
	void getFriendRequest(String uname)
	{	
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			String sqlget="select * from friendship where requested_username='"+uname+"'";
			ps=con.prepareStatement(sqlget);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if((rs.getString("whenrejected")==null)&&(rs.getString("whenconfirmed")==null)&&(rs.getString("whenunfriended")==null))
				{
					System.out.println(rs.getString("requester_username"));
				}
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	} 

}