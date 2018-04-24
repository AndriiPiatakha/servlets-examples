package jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementCreateExample {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String DB_NAME = "mydbtest";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public static void main(String[] argv) {

		try {

			createDbUserTable();

		} catch (SQLException e) {
			System.out.println(1);
			System.out.println(e.getMessage());

		}

	}

	private static void createDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String createTableSQL = "CREATE TABLE DBUSER(" + 
				"USER_ID INT NOT NULL, "
				+ "USERNAME VARCHAR(20) NOT NULL, " 
				+ "CREATED_BY VARCHAR(20) NOT NULL, "
				+ "CREATED_DATE DATE NOT NULL, " 
				+ "PRIMARY KEY (USER_ID) " + ")";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(createTableSQL);
			// execute the SQL stetement
			statement.execute(createTableSQL);

			System.out.println("Table \"dbuser\" is created!");

		} catch (SQLException e) {
			System.out.println(2);
			System.err.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {
			System.out.println(3);
			System.err.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {
			System.out.println(4);
			System.err.println(e.getMessage());

		}

		return dbConnection;

	}

}
