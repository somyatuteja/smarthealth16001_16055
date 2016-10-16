package smartHealth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForumDatabase {
	boolean checkModerator(String uname)
	{	
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			String sqlget="select username from moderator" ;
			ps=con.prepareStatement(sqlget);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String rsuname= rs.getString("username");
				if(rsuname.equals(uname))
				{
					return true;
				}
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	boolean checkEndUser(String uname)
	{	
		try {
			Connection con= ConnectionToDB.getInstance().getConnection();
			PreparedStatement ps;
			String sqlget="select username from enduser" ;
			ps=con.prepareStatement(sqlget);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String rsuname= rs.getString("username");
				if(rsuname.equals(uname))
				{
					return true;
				}
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
		void addForumToDatabase(Forum f )
		{
			try {
				Connection con= ConnectionToDB.getInstance().getConnection();
				PreparedStatement ps;
				String eusqlq="insert into forum values("+f.getForumId()+",'"+f.getTopic()+"','"+f.getURL()+"','"+f.getSummary()+"','"+f.getWhencreated()+"',null,'"+f.getCreatedbymod()+"',null)";
				ps=con.prepareStatement(eusqlq);
				ps.executeUpdate();
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			void addCommentToDatabase(String postusername, String posttimecreated,String commentuname, String commenttime, String commenttext, String Photolocation , String Linklocation, String Videolocation)
			
			{
				try {
					Connection con= ConnectionToDB.getInstance().getConnection();
					PreparedStatement ps;
					String eusqlq="insert into comment values('"+postusername+"','"+posttimecreated+"','"+commentuname+"','"+commenttime+"','"+commenttext+"','"+Photolocation+"','"+Linklocation+"','"+Videolocation+"')";
					ps=con.prepareStatement(eusqlq);
					ps.executeUpdate();
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			void addPostToDatabase(String username, String timecreated, String Forumid, String Textentry, String Photolocation , String Linklocation, String Videolocation)
			{
				try {
					Connection con= ConnectionToDB.getInstance().getConnection();
					PreparedStatement ps;
					String eusqlq="insert into post values('"+username+"','"+timecreated+"','"+Forumid+"','"+Textentry+"','"+Photolocation+"','"+Linklocation+"','"+Videolocation+"')";
					ps=con.prepareStatement(eusqlq);
					ps.executeUpdate();
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}

			void addRatingToDatabase(String Postusername, String Posttimecreated , String Raterusername, String getStars)
			{
				try {
					Connection con= ConnectionToDB.getInstance().getConnection();
					PreparedStatement ps;
					String eusqlq="insert into rating values('"+Postusername+"','"+Posttimecreated+"','"+Raterusername+"',"+getStars+")";
					ps=con.prepareStatement(eusqlq);
					ps.executeUpdate();
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
String getPostTime(int n, String uname, int forumid)
{
			try {
				Connection con= ConnectionToDB.getInstance().getConnection();
				PreparedStatement ps;
				String sqlget="select timecreated from post where forumid="+forumid+" and username='"+uname+"'";
				ps=con.prepareStatement(sqlget);
				ResultSet rs=ps.executeQuery();
				int r=1;
				while(rs.next())
				{
					//System.out.println("User :"+ rs.getString("username")+ "\n Time :"+rs.getString(2)+"\n Text:"+rs.getString(4)+"\n Photo Location "+rs.getString(5)+"\n Link Location"+rs.getString(6)+"\n Video Location"+rs.getString(7)+"\n\n");
				
				if(r==n)
				{
					return rs.getString(1);
				}
				
				}}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
}

					void viewPost(int forumid)
					{
						try {
							Connection con= ConnectionToDB.getInstance().getConnection();
							PreparedStatement ps;
							String sqlget="select * from post where forumid="+forumid;
							ps=con.prepareStatement(sqlget);
							ResultSet rs=ps.executeQuery();
							while(rs.next())
							{
								System.out.println("User :"+ rs.getString("username")+ "\n Time :"+rs.getString(2)+"\n Text:"+rs.getString(4)+"\n Photo Location "+rs.getString(5)+"\n Link Location"+rs.getString(6)+"\n Video Location"+rs.getString(7)+"\n\n");
							}}
						catch (SQLException e) {
							e.printStackTrace();
						}
					}
					void viewComment(String postuname, String time )
					{
						try {
							Connection con= ConnectionToDB.getInstance().getConnection();
							PreparedStatement ps;
							String sqlget="select * from comment where post_username='"+postuname+"' and post_timecreated='"+time+"'";
							ps=con.prepareStatement(sqlget);
							ResultSet rs=ps.executeQuery();
							while(rs.next())
							{
								System.out.println("User :"+ rs.getString(3)+ "\n Time :"+rs.getString(4)+"\n Text:"+rs.getString(5)+"\n Photo Location "+rs.getString(6)+"\n Link Location"+rs.getString(7)+"\n Video Location"+rs.getString(8));
							}}
						catch (SQLException e) {
							e.printStackTrace();
						}
					}

void viewForum()
{
	try {
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;
		String sqlget="select forumid, topic from forum";
		ps=con.prepareStatement(sqlget);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("press"+rs.getInt(1)+"for"+ rs.getString("topic"));
		}}
	catch (SQLException e) {
		e.printStackTrace();
	}	}
	void deleteForum(String mod, int id)
	{
		Connection con= ConnectionToDB.getInstance().getConnection();
		PreparedStatement ps;
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String whenclosed= sdf.format(dt);
		String fsqlq="update forum set whenclosed='"+whenclosed+"' where forumid="+id;
		String fsqlq1="update forum set deletedbyModerator_username='"+mod+"' where forumid="+id;
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
}

