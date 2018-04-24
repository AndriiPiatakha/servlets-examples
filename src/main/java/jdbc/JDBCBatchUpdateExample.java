package jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JDBCBatchUpdateExample {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydbtest";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	private static final DateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	public static void main(String[] argv) {

		try {

			batchInsertRecordsIntoTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void batchInsertRecordsIntoTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String insertTableSQL1 = "INSERT INTO DBUSER"
				+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
				+ "(101,'mkyong','system', " + "str_to_date('August 10 2017', '%M %d %Y'))";

		String insertTableSQL2 = "INSERT INTO DBUSER"
				+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
				+ "(102,'mkyong','system', " + "str_to_date('August 10 2017', '%M %d %Y'))";

		String insertTableSQL3 = "INSERT INTO DBUSER"
				+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
				+ "(103,'mkyong','system', " + "str_to_date('August 10 2017', '%M %d %Y'))";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			dbConnection.setAutoCommit(false);

			statement.addBatch(insertTableSQL1);
			statement.addBatch(insertTableSQL2);
			statement.addBatch(insertTableSQL3);

			statement.executeBatch();

			dbConnection.commit();

			System.out.println("Records are inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

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

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

	private static String getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return dateFormat.format(today.getTime());

	}

}
