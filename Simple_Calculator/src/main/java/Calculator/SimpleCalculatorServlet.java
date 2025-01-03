package Calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		String operation = request.getParameter("operation");

		double result = 0;

		switch (operation) {
		case "add":
			result = num1 + num2;
			break;

		case "sub":
			result = num1 - num2;
			break;

		case "multi":
			result = num1 * num2;
			break;

		case "div":
			result = num1 / num2;
			break;

		default:
			response.getWriter().println("<h1>ERROR</h1>");
			return;
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Calculation Result</h2>");
		out.println("<p>" + num1 + " " + (operation) + " " + num2 + " = " + result + "</p>");
		out.println("<a href='simplecalcy.html'>Back To Page</a>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
