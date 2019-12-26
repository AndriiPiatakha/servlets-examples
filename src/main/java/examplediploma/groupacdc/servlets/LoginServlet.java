package examplediploma.groupacdc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examplediploma.groupacdc.dao.UserDao;
import examplediploma.groupacdc.dao.impl.DefaultUserDao;
import examplediploma.groupacdc.models.UserData;

@WebServlet(name = "LoginServlet2", urlPatterns = { "/login2" })
public class LoginServlet extends HttpServlet {

	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/groupacdc/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
			response.sendRedirect(getServletContext().getContextPath() + "/login2");
		} else {
			UserData user = userDao.getUserById(Integer.parseInt(login));
			if (user.getFirstName().equals(password)) {
				response.sendRedirect(getServletContext().getContextPath() + "/homePage");
			} else {
				response.sendRedirect(getServletContext().getContextPath() + "/login2");
			}
		}
		
	}

}
