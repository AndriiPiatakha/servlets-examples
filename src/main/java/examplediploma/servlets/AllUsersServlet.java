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

@WebServlet("/AllUsersServlet")
public class AllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private UserDao userDao;

    public AllUsersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDao = DefaultUserDao.getUserDaoInstance();
		List<UserData> users = userDao.getAllUsers();
		request.setAttribute("users", users);
		RequestDispatcher rd = request.getRequestDispatcher("/examplediploma/allusers.jsp");
		rd.forward(request, response);
	}

}
