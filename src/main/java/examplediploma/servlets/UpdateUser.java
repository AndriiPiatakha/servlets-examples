package examplediploma.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import examplediploma.facades.UserFacade;
import examplediploma.models.User;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserFacade userFacade;
	{
		userFacade = new UserFacade();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = userFacade.getUserById(1);
		session.setAttribute("currentUser", user);
		System.out.println(user);
		request.setAttribute("user", user); // set attribute for .jsp
		RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/views/updateUser.jsp");
		rs.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DO POST - Update User");
		HttpSession session = request.getSession();
//		Enumeration<String> parameterNames = request.getParameterNames();
//		while(parameterNames.hasMoreElements()) {
//			System.out.println(parameterNames.nextElement());
//		}

		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String lastName = request.getParameter("last_name");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		
		System.out.println(userId);
		System.out.println(name);

		User user = new User();
		user.setName(name);
		user.setLastName(lastName);
		user.setEmail(email);
		session.setAttribute("currentUser", user);
		
		response.getWriter().write(getServletContext().getContextPath() + "/successUpdate");
		
		
//		List<String> errors = userService.validateUser(user);
//		String errorNameMessage = userService.validateNameForUser(user);
//		String errorNameMessage = "some error message";
//		if (errorNameMessage != null) {
//			request.setAttribute("nameErrorMessage", errorNameMessage);
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/updateUser.jsp");
//			rd.forward(request, response);
//		}
		
//		response.sendRedirect("/successUpdate");

	}

}
