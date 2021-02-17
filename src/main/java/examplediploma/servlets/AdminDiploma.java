package examplediploma.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examplediploma.dao.UserDao;
import examplediploma.dao.impl.DefaultUserDao;
import examplediploma.models.UserData;


@WebServlet("/admin")
public class AdminDiploma extends HttpServlet {


	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getUserDaoInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserData> users = userDao.getAllUsers();
		request.setAttribute("users", users);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/examplediploma/admin.jsp");
		rd.forward(request, response); 
	}
}
