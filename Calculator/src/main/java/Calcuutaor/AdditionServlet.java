package Calcuutaor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num1Str = request.getParameter("num1");
		String num2Str = request.getParameter("num2");
		
		
		int num1 = Integer.parseInt(num1Str);
		int num2 = Integer.parseInt(num2Str);
		
		int result = num1+num2;
		
		response.setContentType("text/html");
		
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Result: " + num1 + " + " + num2 + " = " + result + "</h2>");
        out.println("<a href='calcy.html'>Back</a>");
        out.println("</body></html>");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
