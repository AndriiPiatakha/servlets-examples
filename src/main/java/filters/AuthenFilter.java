package filters;

//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.util.*;

//Implements Filter class
//@WebFilter
public class AuthenFilter implements Filter {
	public void init(FilterConfig config) throws ServletException {

		// Get init parameter
		String testParam = config.getInitParameter("test-param");

		// Print the init parameter
		System.out.println("Test Param: " + testParam);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
//		HttpServletRequest tSr = (HttpServletRequest) request;
//		tSr.getSession();
//		tSr.isUserInRole("ROLE_ADMIN");
		
		// Get the IP address of client machine.
		String ipAddress = request.getRemoteAddr();

		// Log the IP address and current timestamp.
		System.out.println("IP " + ipAddress + ", Time " + new Date().toString());

		// Pass request back down the filter chain
		chain.doFilter(request, response);
		
		// Smth what should be done sending request back
		System.out.println("====== exiting filter");
		
		
//		HttpServletRequest r = (HttpServletRequest)request;
//		r.getSession();
//		request.getSession();
//		HttpServletResponse resp = (HttpServletResponse)response;
//		resp.setStatus(403);
//		resp.setHeader(name, value);
//		resp.sendError(403);
		
	}

	public void destroy() {
		/*
		 * Called before the Filter instance is removed from service by the web
		 * container
		 */
	}
}