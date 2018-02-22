package servlets;

//Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//	http://localhost:8080/sourceitWeb/helloForm?first_name=ZARA&last_name=ALI

//Extend HttpServlet class
@WebServlet(urlPatterns = "/helloForm")
public class HelloForm extends HttpServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		// Create cookies for first and last names.
		Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
		Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));
		
		// Add both the cookies in the response header.
		response.addCookie(firstName);
		response.addCookie(lastName);

		PrintWriter out = response.getWriter();
		String title = "Using GET Method to Read Form Data";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>First Name</b>: " + request.getParameter("first_name") + "\n" + "  <li><b>Last Name</b>: "
				+ request.getParameter("last_name") + "\n" + "</ul>\n" + "</body>" + "</html>");
	}
}