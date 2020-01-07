package examplediploma.groupacdc.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(servletNames = { "MyAccountServlet2" })
public class MyAccountFilter implements Filter {
	

	public static final String LOGGED_IN_USER_KEY = "loggedInUser";

	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		HttpSession session = httpRequest.getSession(false);
		if (session != null && session.getAttribute(LOGGED_IN_USER_KEY) != null) {
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect( 
					httpRequest.getServletContext()
					.getContextPath() + "/login2");
		}
		
	}

}
