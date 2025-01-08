package sesssiontackinghttpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.setAttribute("username", uname);
		session.setAttribute("password", pass);
		
		out.print("<h1>Welcome to Seed Infotech :"+uname);
		out.print("<form action='servlet2'>");
		out.print("<input type = 'submit' value='submit'>");
		out.print("</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
