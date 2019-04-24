package examplediploma.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examplediploma.dao.UserDao;
import examplediploma.dao.impl.DefaultUserDao;
import examplediploma.models.UserData;

/**
 * Servlet implementation class SIgnUpDiploma
 */
@WebServlet("/signUpDiploma")
public class SignUpDiploma extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData userData = new UserData();
		userData.setName(request.getParameter("first_name"));
		userData.setLastName(request.getParameter("last_name"));
		userData.setPassword(request.getParameter("password"));
		
		userDao = DefaultUserDao.getUserDaoInstance();
		userDao.saveUser(userData);
		
		response.sendRedirect(getServletContext().getContextPath() + "/examplediploma/successSignUp.jsp");
	}

}
