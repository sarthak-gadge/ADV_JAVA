package userloginCalculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginFirstServlet")
public class LoginFirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correctusername = "Sarthak";
		String correctpassword = "admin";
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		
		if(uname.equals(correctusername) && pass.equals(correctpassword)) {
			out.print("<h1>User Login Successfully!!!</h1>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/calculator.html");
			rd.include(request, response);
		}
		else {
			out.print("<h1>Incorrect login!!!</h1>");
		}
		
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
