package smartHealth;
public class HealthData {
private String username;
private int property;
private String value;
static int id=0;
private int datumid;
private String dateset;
public HealthData(String username,int property,String value)
{
	this.setUsername(username);
	this.setProperty(property);
	this.setValue(value);
	java.util.Date dt = new  java.util.Date();
    java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	this.setDateset(sdf.format(dt));
	setDatumid(++id);
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getProperty() {
	return property;
}
public void setProperty(int property) {
	this.property = property;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public String getDateset() {
	return dateset;
}
public void setDateset(String dateset) {
	this.dateset = dateset;
}
public int getDatumid() {
	return datumid;
}
public void setDatumid(int datumid) {
	this.datumid = datumid;
}
}
