package servlets;

import java.io.*;

//import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
@WebServlet("/sendError")
public class ShowError extends HttpServlet {
 
   // Method to handle GET method request.
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      System.out.println("IN SHOW ERROR ============");
      // Set error code and reason.
      response.sendError(405, "Need authentication!!!" );
   }
   
   // Method to handle POST method request.
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      doGet(request, response);
   }
}
