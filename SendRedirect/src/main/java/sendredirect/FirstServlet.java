package sendredirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("uname");
		PrintWriter out = response.getWriter();
		
		out.print("<h1>Welcome "+user);
		
		
//		sendredirect ni direct apan ji link takal tya link open hotil.
//		response.sendRedirect("http://www.youtube.com");
//		response.sendRedirect("https://www.google.com/");
		response.sendRedirect("https://github.com/sarthak-gadge");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
