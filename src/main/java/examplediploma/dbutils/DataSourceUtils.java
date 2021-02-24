package examplediploma.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceUtils {

	private static DataSource instance;
	
	static {
		try {
			InitialContext initialContext = new InitialContext();
			Context context = (Context) initialContext.lookup("java:comp/env");
			// The JDBC Data source that we just created
			instance = (DataSource) context.lookup("connpool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private DataSourceUtils() {
	}

	public static synchronized DataSource getDataSource() {
		if (instance == null) {
			InitialContext initialContext;
			try {
				initialContext = new InitialContext();
				Context context = (Context) initialContext.lookup("java:comp/env");
				// The JDBC Data source that we just created
				instance = (DataSource) context.lookup("connpool");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public static synchronized Connection getConnection() {
		try {
			return instance.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
