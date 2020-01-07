package examplediploma.groupacdc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examplediploma.dao.UserDao;
import examplediploma.dao.impl.DefaultUserDao;
import examplediploma.models.UserData;


@WebServlet(name = "AllUsersServlet2", urlPatterns = { "/allUsersServlet2" })
public class AllUsersServlet extends HttpServlet {
	
	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getUserDaoInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UserData> users = userDao.getAllUsers();
		request.setAttribute("users", users);
		
		UserData loggedInUser = new UserData();
		loggedInUser.setRole("admin");
		request.setAttribute("loggedInUser", loggedInUser);
		
		request.getRequestDispatcher("WEB-INF/views/groupacdc/allUsers.jsp")
			.forward(request, response);
		
	}

}
