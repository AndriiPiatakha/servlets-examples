package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoPrg
 */
@WebServlet("/SignIn")
public class DemoPrg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("In post");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("demoPRG.jsp");
//		requestDispatcher.forward(request, response);
		
		response.sendRedirect("demoPRG.jsp");
	}

}
