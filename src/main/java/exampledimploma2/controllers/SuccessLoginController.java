package exampledimploma2.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/successLogin")
public class SuccessLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("errMsg");
		System.out.println("==================================== " + parameter);
		request.setAttribute("errMsg", parameter);
		request
			.getRequestDispatcher("WEB-INF/views/group_eagles/successLogin.jsp")
			.forward(request, response);
	}

}
