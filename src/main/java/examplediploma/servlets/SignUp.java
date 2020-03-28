package examplediploma.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examplediploma.facades.UserFacade;
import examplediploma.models.UserData;

@WebServlet("/public/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserFacade userFacade;
	
	{
		userFacade = new UserFacade();
	}

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/views/signup.jsp");
		rs.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=========== DO POST");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		UserData user = new UserData();
		user.setName(name);
		user.setEmail(email);
		// TODO add validation to validate name and email are not empty
		if (userFacade.saveUser(user)) {
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/success.jsp");
			rd.forward(request, response);
		}
		// TODO forward to error page
	}

}
