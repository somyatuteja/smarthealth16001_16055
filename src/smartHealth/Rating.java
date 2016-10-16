package smartHealth;
public class Rating {
private String postusername;
private int stars;
private String posttimecreated;
private String raterusername;
Rating(String puname, String runame, String ptimecreated, int stars)
{
	this.setPosttimecreated(ptimecreated);
	this.setPostusername(puname);
	this.setStars(stars);
	this.setRaterusername(runame);
}
/**
 * @return the postusername
 */
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
 * @return the stars
 */
public int getStars() {
	return stars;
}
/**
 * @param stars the stars to set
 */
public void setStars(int stars) {
	this.stars = stars;
}
/**
 * @return the posttimecreated
 */
public String getPosttimecreated() {
	return posttimecreated;
}
/**
 * @param posttimecreated the posttimecreated to set
 */
public void setPosttimecreated(String posttimecreated) {
	this.posttimecreated = posttimecreated;
}
/**
 * @return the raterusername
 */
public String getRaterusername() {
	return raterusername;
}
/**
 * @param raterusername the raterusername to set
 */
public void setRaterusername(String raterusername) {
	this.raterusername = raterusername;
}


}
