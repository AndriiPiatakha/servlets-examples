package examplediploma.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import examplediploma.dao.UserDao;
import examplediploma.dao.impl.DefaultUserDao;
import examplediploma.models.UserData;
import examplediploma.services.UserService;
import examplediploma.services.impl.DefaultUserService;

@WebServlet("/loginDiploma")
public class LoginDiploma extends HttpServlet {
	public static final String LOGGED_IN_USER_ATTRIBUTE = "loggedInUser";
	public static final String ERROR_MSG_ATTRIBUTE = "errorMsg";
	public static final String USER_NOT_FOUND_ERR_MSG = "Password or Email is not valid";
	public static final String PASSWORD_PARAMETER = "password";
	public static final String EMAIL_PARAMETER = "email";

	private static final long serialVersionUID = 1L;

	private UserDao userDao;
	private UserService userService = DefaultUserService.getUserServiceInstance();

	{
		userDao = DefaultUserDao.getUserDaoInstance();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "\t" + cookie.getValue());
		}
		
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
		
		if (session != null && session.getAttribute(LOGGED_IN_USER_ATTRIBUTE) != null) {
			UserData user = (UserData) session.getAttribute(LOGGED_IN_USER_ATTRIBUTE);
			redirectUserByRole(request, response, user);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/examplediploma/login.jsp");
			rd.forward(request, response);
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter(EMAIL_PARAMETER);
		String password = request.getParameter(PASSWORD_PARAMETER);

		UserData user = userDao.getUserByEmail(email);
		if (user != null) {
			loginUser(request, response, password, user);
		} else {
			forwardBackToLoginWhenError(request, response);
		}
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response, String password, UserData user)
			throws ServletException, IOException {
		if (user.getPassword() != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute(LOGGED_IN_USER_ATTRIBUTE, user);
			redirectUserByRole(request, response, user);
		} else {
			forwardBackToLoginWhenError(request, response);
		}
	}
	
	private void redirectUserByRole(HttpServletRequest request, HttpServletResponse response, UserData user) throws IOException {
		if (userService.isAdminUser(user)) {
			response.sendRedirect(getServletContext().getContextPath() + "/admin");
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "/myaccount");
		}
	}

	private void forwardBackToLoginWhenError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(ERROR_MSG_ATTRIBUTE, USER_NOT_FOUND_ERR_MSG);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/examplediploma/login.jsp");
		rd.forward(request, response);
	}

}
