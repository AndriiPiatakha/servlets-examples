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
@WebServlet("/public/signUpDiploma")
public class SignUpDiploma extends HttpServlet {
	private static final String RESOURCE_TO_REDIRECT = "/examplediploma/successSignUp.jsp";

	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getUserDaoInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData userData = new UserData();
		
		// Error handling added to demo specific test with Mockito
		try {
			userData.setName(request.getParameter("first_name"));
			userData.setLastName(request.getParameter("last_name"));
			userData.setPassword(request.getParameter("password"));
		} catch (RuntimeException e) {
			return;
		}
	
		
		// TODO validation
		
		userDao.saveUser(userData);
		
		response.sendRedirect(getServletContext().getContextPath() + RESOURCE_TO_REDIRECT);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;	
	}

}
