package examplediploma.groupacdc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examplediploma.groupacdc.dao.UserDao;
import examplediploma.groupacdc.dao.impl.DefaultUserDao;

/**
 * Servlet implementation class UpdateUserServlet2
 */
@WebServlet("/updateUserServlet2")
public class UpdateUserServlet2 extends HttpServlet {
	
	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", 
				userDao.getUserById(Integer.parseInt(request.getParameter("userId"))));
		request.getRequestDispatcher("WEB-INF/views/groupacdc/updateUser.jsp")
			.forward(request, response);
		
	}
}
