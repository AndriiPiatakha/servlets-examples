package examplediploma.filters;

import static examplediploma.servlets.LoginDiploma.LOGGED_IN_USER_ATTRIBUTE;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import examplediploma.models.UserData;
import examplediploma.services.UserService;
import examplediploma.services.impl.DefaultUserService;

@WebFilter({"/admin/*","/myaccount/*"})
public class AdminFilter implements Filter {
	
	private ServletContext servletContext;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		servletContext = filterConfig.getServletContext();
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		UserService userService = DefaultUserService.getUserServiceInstance();
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if (session != null) {
			UserData user = (UserData)session.getAttribute(LOGGED_IN_USER_ATTRIBUTE);
			
			if (isRedirectedToLoginPageIfUserIsEmpty(user, response)) {
				return;
			}
			
			if (userService.isAdminUser(user)) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendError(403);
			}
		} else {
			isRedirectedToLoginPageIfUserIsEmpty(null, response);
		}
	}


	private boolean isRedirectedToLoginPageIfUserIsEmpty(UserData user, ServletResponse response) 
			throws IOException {
		if (user == null) {
			((HttpServletResponse) response)
					.sendRedirect(servletContext.getContextPath() + "/loginDiploma");
			return true;
		} else {
			// do nothing
			return false;
		}
	}

}
