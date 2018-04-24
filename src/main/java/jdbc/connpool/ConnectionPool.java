package jdbc.connpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class ConnectionPool {

	// JDBC Driver Name & Database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/sourceit";

	// JDBC Database Credentials
	static final String JDBC_USER = "root";
	static final String JDBC_PASS = "root";

	private static GenericObjectPool gPool = null;

	@SuppressWarnings("unused")
	public DataSource setUpPool() throws Exception {
		Class.forName(JDBC_DRIVER);

		// Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);

		// Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
		ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);

		// Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
		return new PoolingDataSource(gPool);
	}

	public GenericObjectPool getConnectionPool() {
		return gPool;
	}

	// This Method Is Used To Print The Connection Pool Status
	private void printDbStatus() {
		System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
	}

	public static void main(String[] args) {
		ResultSet rsObj = null;
		Connection connObj = null;
		PreparedStatement pstmtObj = null;
		ConnectionPool jdbcObj = new ConnectionPool();
		
		
		try {	
			DataSource dataSource = jdbcObj.setUpPool();
			jdbcObj.printDbStatus();

			// Performing Database Operation!
			System.out.println("\n=====Making A New Connection Object For Db Transaction=====\n");
			connObj = dataSource.getConnection();
			jdbcObj.printDbStatus(); 

//			pstmtObj = connObj.prepareStatement("SELECT * FROM technical_editors");
//			rsObj = pstmtObj.executeQuery();
//			while (rsObj.next()) {
//				System.out.println("Username: " + rsObj.getString("tech_username"));
//			}
			System.out.println("\n=====Releasing Connection Object To Pool=====\n");			
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				// Closing ResultSet Object
				if(rsObj != null) {
					rsObj.close();
				}
				// Closing PreparedStatement Object
				if(pstmtObj != null) {
					pstmtObj.close();
				}
				// Closing Connection Object
				if(connObj != null) {
					connObj.close();
				}
			} catch(Exception sqlException) {
				sqlException.printStackTrace();
			}
		}
		jdbcObj.printDbStatus();
	}
}