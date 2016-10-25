package smartHealth;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String pic1=request.getParameter("pic1");
		String pic2=request.getParameter("pic2");
		String pic3=request.getParameter("pic3");
		String streetno=request.getParameter("streetno");
		String streetname=request.getParameter("streetname");
		String mun=request.getParameter("mun");
		String govdis=request.getParameter("govdis");
		String parea=request.getParameter("parea");
		String aboutme=request.getParameter("aboutme");
        EndUser eu=new EndUser(	uname, password,fname,  lname,  email1,	
				email2, pic1, pic2,pic3,aboutme,
				streetname,streetno, parea,  mun,"new", govdis);
    	Database dbase = new Database();
    	dbase.addEndUserToDatabase(eu);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
