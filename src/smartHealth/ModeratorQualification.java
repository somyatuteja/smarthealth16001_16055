package smartHealth;

import java.sql.ResultSet;

public class ModeratorQualification {

public ResultSet getQualifications()
{
	Database db=new Database();
	ResultSet rs= db.showQualifications();
	return rs;
}

}
