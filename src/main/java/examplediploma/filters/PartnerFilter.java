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


@WebFilter("/*")
public class PartnerFilter implements Filter {

	private static final String PARTNER_ID = "partnerId";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String parameter = request.getParameter(PARTNER_ID);
		if (parameter != null) {
			Cookie cookie = new Cookie(PARTNER_ID, parameter);
			((HttpServletResponse) response).addCookie(cookie);
		}
		chain.doFilter(request, response);
	}
}
