package examplediploma.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createUser")
public class UserRegistration extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String userName = req.getParameter("name");
		String userLastName = req.getParameter("lastName");
		
		// use facade to save user in db
		// userFacade.createUser(new User(userName, userLastName));
		
		System.out.println("User name = " + userName);
		System.out.println("User last name = " + userLastName);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String userName = req.getParameter("name");
		String userLastName = req.getParameter("lastName");
		
		// use facade to save user in db
		// userFacade.createUser(new User(userName, userLastName));
		
		System.out.println("User name = " + userName);
		System.out.println("User last name = " + userLastName);
	}

}
