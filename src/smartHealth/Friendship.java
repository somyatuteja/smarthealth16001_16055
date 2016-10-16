package smartHealth;


public class Friendship {
private String requesterusername;
private String requestedusername;
private String whenrequested;
private String whenconfirmed;
private String whenrejected;
private String whenunfriended;
Friendship(String u1, String u2) // Constructor of friendship
{
	requesterusername=u1;
	requestedusername=u2;
	java.util.Date dt = new java.util.Date();
java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
this.whenrequested= sdf.format(dt);
}
public String getRequesterUsername1() {
	return requesterusername;
}
public String getRequestedUsername2() {
	return requestedusername;
}
public String getWhenRequested() {
	return whenrequested;
}
public String getWhenconfirmed() {
	return whenconfirmed;
}
public String getWhenrejected() {
	return whenrejected;
}
public String getWhenunfriended() {
	return whenunfriended;
}
public void acceptRequest()
{
	
}
public void rejectRequest() // sets the time at which rejected 
{
	java.util.Date dt = new java.util.Date();
java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
this.whenrejected= sdf.format(dt);
}
public void unFriend() //sets the time at which unfriend
{
	java.util.Date dt = new java.util.Date();
java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
this.whenconfirmed= sdf.format(dt);
}
}