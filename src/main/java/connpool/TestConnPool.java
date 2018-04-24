package connpool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;



/**
 * Servlet implementation class TestConnPool
 */
@WebServlet("/TestConnPool")
public class TestConnPool extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestConnPool() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InitialContext initialContext;
		try {
			initialContext = new InitialContext();
			Context context = (Context) initialContext.lookup("java:comp/env");
			// The JDBC Data source that we just created
			DataSource ds = (DataSource) context.lookup("connpool");	
			Connection connection = ds.getConnection();
			System.out.println(connection.hashCode());
			
		
			
			connection.close();
			
			System.out.println(connection);

			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
