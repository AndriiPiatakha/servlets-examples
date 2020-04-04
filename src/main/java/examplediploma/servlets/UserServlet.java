package examplediploma.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examplediploma.facades.UserFacade;
import examplediploma.models.UserData;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserFacade userFacade;
	
	{
		userFacade = new UserFacade();
	}
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		if (userId != null) {
			UserData user = userFacade.getUserById(Integer.valueOf(userId));
			System.out.println(user);
			response.getWriter().println(user);
		}
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
