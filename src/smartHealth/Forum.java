package smartHealth;

import java.util.ArrayList;

public class Forum {
	static int lastforumid=0;
private int forumid;
private String topic;
private String URL;
private String summary;
private String whencreated;
private String whenclosed;
private String createdbymod;
private String closedbymod;
private ArrayList<Post> postlist = new ArrayList<Post>();

Forum(String topic, String URL, String summary, String modname)
{
	this.setTopic(topic);
	this.setURL(URL);
	this.setSummary(summary);
	this.setCreatedbymod(modname);
	this.forumid=++lastforumid;
    java.util.Date dt = new  java.util.Date();
    
   	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
   	this.setWhencreated(sdf.format(dt));
}

Post addPost(String uname , String timecreated, String textentry, String photolocation, String linklocation,String  videolocation)
{
	Post p=new Post(uname, this.forumid , textentry, photolocation, linklocation, videolocation);
	postlist.add(p);
	return p;
	
}

/**
 * @return the topic
 */
public String getTopic() {
	return topic;
}

/**
 * @param topic the topic to set
 */
public void setTopic(String topic) {
	this.topic = topic;
}

/**
 * @return the uRL
 */
public String getURL() {
	return URL;
}
public int getForumId() {
	return this.forumid;
}
/**
 * @param uRL the uRL to set
 */
public void setURL(String uRL) {
	URL = uRL;
}

/**
 * @return the summary
 */
public String getSummary() {
	return summary;
}

/**
 * @param summary the summary to set
 */
public void setSummary(String summary) {
	this.summary = summary;
}

/**
 * @return the whencreated
 */
public String getWhencreated() {
	return whencreated;
}

/**
 * @param whencreated the whencreated to set
 */
public void setWhencreated(String whencreated) {
	this.whencreated = whencreated;
}

/**
 * @return the whenclosed
 */
public String getWhenclosed() {
	return whenclosed;
}

/**
 * @param whenclosed the whenclosed to set
 */
public void setWhenclosed(String whenclosed) {
	this.whenclosed = whenclosed;
}

/**
 * @return the createdbymod
 */
public String getCreatedbymod() {
	return createdbymod;
}

/**
 * @param createdbymod the createdbymod to set
 */
public void setCreatedbymod(String createdbymod) {
	this.createdbymod = createdbymod;
}

/**
 * @return the closedbymod
 */
public String getClosedbymod() {
	return closedbymod;
}

/**
 * @param closedbymod the closedbymod to set
 */
public void setClosedbymod(String closedbymod) {
	this.closedbymod = closedbymod;
}
}