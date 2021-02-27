package examplediploma.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("productNameValue"));
		System.out.println(req.getParameter("categoryValue"));
		System.out.println(req.getParameter("priceValue"));
		
		resp.getWriter().write("success");
		
		// in case of error
		/*
		 * get by ID original state - 
		 * Convert to JSON (GSON Library) 
		 * 
		 */
		
		resp.sendError(500, "json");
	}

	
	
}
