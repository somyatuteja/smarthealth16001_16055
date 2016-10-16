package smartHealth;

public class Comment {
private String postusername;
private String posttimecreate;
private String commentusername;
private String commenttime;
private String photolocation;
private String commenttext;
private String videolocation;
private String linklocation;
Comment(String postusername , String posttimecreated, String commentusername, String commenttime,  String commenttext, String photolocation, String videolocation, String linklocation )
{
	this.setPostusername(postusername);
	this.setPosttimecreate(posttimecreated);
	this.setCommentusername(commentusername);
	this.setPhotolocation(photolocation);
	this.setCommenttext(commenttext);
	this.setVideolocation(videolocation);
	this.setLinklocation(linklocation);
	java.util.Date dt = new  java.util.Date();
    
   	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
   	this.setCommenttime(sdf.format(dt));
	
}
public String getPostusername() {
	return postusername;
}
/**
 * @param postusername the postusername to set
 */
public void setPostusername(String postusername) {
	this.postusername = postusername;
}
/**
 * @return the posttimecreate
 */
public String getPosttimecreate() {
	return posttimecreate;
}
/**
 * @param posttimecreate the posttimecreate to set
 */
public void setPosttimecreate(String posttimecreate) {
	this.posttimecreate = posttimecreate;
}
/**
 * @return the commentusername
 */
public String getCommentusername() {
	return commentusername;
}
/**
 * @param commentusername the commentusername to set
 */
public void setCommentusername(String commentusername) {
	this.commentusername = commentusername;
}
public String getCommenttime() {
	return commenttime;
}
public void setCommenttime(String commenttime) {
	this.commenttime = commenttime;
}
public String getPhotolocation() {
	return photolocation;
}
public void setPhotolocation(String photolocation) {
	this.photolocation = photolocation;
}
public String getCommenttext() {
	return commenttext;
}
/**
 * @param commenttext the commenttext to set
 */
public void setCommenttext(String commenttext) {
	this.commenttext = commenttext;
}
public String getVideolocation() {
	return videolocation;
}
public void setVideolocation(String videolocation) {
	this.videolocation = videolocation;
}
public String getLinklocation() {
	return linklocation;
}
public void setLinklocation(String linklocation) {
	this.linklocation = linklocation;
}


}
