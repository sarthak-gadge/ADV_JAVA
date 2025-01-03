package loginpageees;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String correctusername = "Sarthak";
		String correctpassword = "admin";
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		
		if(uname.equals(correctusername) && pass.equals(correctpassword)) {
			out.print("<h1>User Login Successfully!!!</h1>");
		}
		else {
			out.print("<h1>Incorrect login!!!</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

}
