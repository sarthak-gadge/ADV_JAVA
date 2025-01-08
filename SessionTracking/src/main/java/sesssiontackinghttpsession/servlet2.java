package sesssiontackinghttpsession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession();
		 String user =  (String) session.getAttribute("username");
		 out.println("<h1>Welcome Back "+user);
		 
		 String id=session.getId();
		 out.print("<h1>Session ID is: "+id);
		 
//		 get session created.
		 long creationTime = session.getCreationTime(); 
		 
//		 convert creation time to readable format.
		 Date creationDate = new Date(creationTime);
		 out.println("<p>Session created At: "+creationDate + "</p>");
		 session.invalidate();
		 
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
