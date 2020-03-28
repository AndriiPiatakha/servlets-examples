package exampledimploma2.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exampledimploma2.dao.UserDao;
import exampledimploma2.dao.impl.DefaultUserDao;
import exampledimploma2.models.UserData;


@WebServlet(urlPatterns = {"/GetUserController"})
public class GetUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData user = userDao
				.getUserById(Integer.valueOf(request.getParameter("id")));
//		response.getWriter().println("<html><body></body></html>");
		
		request.setAttribute("loggedInUser", user);
		request.getRequestDispatcher("WEB-INF/views/group_eagles/user.jsp")
				.forward(request, response);
		
//		response.sendRedirect(getServletContext().getContextPath() + "/successLogin?errMsg=some error");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("login");
		String password = request.getParameter("password");
		System.out.println("******************** " + userName + " " + password);
	}

}
