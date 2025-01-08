package Servlet_Collabration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("uname");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Welcome "+user);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/SecondServlet");
		rd.include(request,response);
//		include use kel tr donhi page che answer show krta.
//		forward use kel tr direct next page ch answer show krt.(first page ch answer nahi show hot.)
//		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
