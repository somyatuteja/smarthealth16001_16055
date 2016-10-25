<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="smartHealth.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<form action="Register" >
Enter Username
<input name="uname" />
<br><br>
Enter Password
<input name="password" />
<br><br>
Enter Email1
<input name="email1" />
<br><br>
Enter Email2
<input name="email2" />
<br><br>
Enter First Name
<input name="fname" />
<br><br>
Enter Last Name
<input name="lname" />
<br><br>
Enter URL of photo 1
<input name="pic1" />
<br><br>
Enter URL of photo 2
<input name="pic2" />
<br><br>
Enter URL of photo 3
<input name="pic3" />
<br><br>
Enter Street No.
<input name="streetno" />
<br><br>
Enter Street Name
<input name="streetname" />
<br><br>
Enter Major Municipality
<input name="mun" />
<br><br>
Enter Governing District
<input name="govdis" />
<br><br>
Enter Postal Area
<input name="parea" />
<br><br>
Enter About You
<input name="aboutme" />
<br><br>
<input type="radio" name="group1" value="enduser" checked > End User<br>
<input type="radio" name="group1" value="moderator"> Moderator<br>
<input type="radio" name="group1" value="admin">Administrator <br><br>
Enter Phone no.(Only moderator and admin)
<input name="pno" />
<br><br>
<%
ModeratorQualification mq=new ModeratorQualification();
ResultSet resultset=mq.getQualifications();
%> <select>
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(2)%></option>
        <% } %>
        </select>

<input type="submit" />


</form>
</body>
</html>