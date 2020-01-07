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

@WebServlet("/userById")
public class ShowUserByIdServlet extends HttpServlet {

	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData user = userDao.getUserById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("user", user);
		request.getRequestDispatcher("WEB-INF/views/groupacdc/showUser.jsp")
			.forward(request, response);
		
	}

}
