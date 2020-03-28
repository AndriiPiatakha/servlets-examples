package examplediploma.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/public/*")
public class PartnerFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String parameter = request.getParameter("partnerId");
		if (parameter != null) {
			Cookie cookie = new Cookie("partnerId", parameter);
			((HttpServletResponse) response).addCookie(cookie);
		}
		chain.doFilter(request, response);
	}
}
