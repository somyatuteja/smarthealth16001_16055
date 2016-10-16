package smartHealth;

import java.util.ArrayList;
import java.util.Iterator;

public class Post {
private String username;
private int forumid;
private String timecreated;
private String textentry;
private String photolocation;
private String linklocation;
private String videolocation;
private ArrayList<Comment> commentlist = new ArrayList<Comment>();
private ArrayList<Rating> ratinglist = new ArrayList<Rating>();
public Post(String username,  int forumid, String textentry, String photolocation, String linklocation,String videolocation)
{
	this.setUsername(username);
	this.setForumid(forumid);
	this.setTextentry(textentry);
	this.setPhotolocation(photolocation);
	this.setLinklocation(linklocation);
	this.setVideolocation(videolocation);
java.util.Date dt = new  java.util.Date();
    
   	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
   	this.timecreated= sdf.format(dt);
	
}
/**
 * @return the username
 */
public String getUsername() {
	return username;
}
/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}
/**
 * @return the forumid
 */
public int getForumid() {
	return forumid;
}
/**
 * @param forumid the forumid to set
 */
public void setForumid(int forumid) {
	this.forumid = forumid;
}
/**
 * @return the timecreated
 */
public String getTimecreated() {
	return timecreated;
}
public void setTimecreated(String timecreated) {
	this.timecreated = timecreated;
}
public String getTextentry() {
	return textentry;
}
public void setTextentry(String textentry) {
	this.textentry = textentry;
}
public String getPhotolocation() {
	return photolocation;
}
public void setPhotolocation(String photolocation) {
	this.photolocation = photolocation;
}
public String getLinklocation() {
	return linklocation;
}
public void setLinklocation(String linklocation) {
	this.linklocation = linklocation;
}
public String getVideolocation() {
	return videolocation;
}
public void setVideolocation(String videolocation) {
	this.videolocation = videolocation;
}
public Rating addRating(String runame, int stars )
{
	Rating r=new Rating(this.username, runame, this.timecreated, stars);
	this.ratinglist.add(r);
	return r;	
}
public Comment addComment(String commentusername, String commenttime,  String commenttext, String photolocation, String videolocation, String linklocation )
{
	Comment c= new Comment(this.username , this.timecreated , commentusername, commenttime, commenttext,  photolocation, videolocation, linklocation );
	this.commentlist.add(c);
	return c;
}
public void viewComments()
{
	Iterator<Comment> itr = this.commentlist.iterator();
	while(itr.hasNext())
	{
		Comment c= (Comment) itr.next();
		System.out.println(c.getCommenttext());
	}
}
	
	}



