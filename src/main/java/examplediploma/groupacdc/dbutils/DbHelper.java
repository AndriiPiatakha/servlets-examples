package examplediploma.groupacdc.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/mytestdb";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8&useSSL=false";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	private static DbHelper instance;
	
	private DbHelper() {
	}
	
	public synchronized static DbHelper getInstance() {
		if (instance == null) {
			instance = new DbHelper();
		}
		return instance;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL + PARAMS, USER, 
					PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	

}
