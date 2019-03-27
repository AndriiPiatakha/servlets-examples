package lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LesonJdbc {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "travel_agency";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static Connection getDBConnection() {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(1);
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println(2);
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static void createUserTable() throws SQLException {

        String createTableSQL = "CREATE TABLE users(user_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "first_name VARCHAR(30), last_name VARCHAR(30))";

        try (Connection dbConnection = getDBConnection();
             Statement statement = dbConnection.createStatement()) {
            System.out.println(createTableSQL);
            statement.execute(createTableSQL);
            System.out.println("Table users is creates!");
        } catch (SQLException e) {
            System.out.println(3);
            System.out.println(e.getMessage());
        }
    }

    public static void createToursTable() throws SQLException {

        String createTableSQL = "CREATE TABLE tours(tour_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "tour_name VARCHAR(30), country VARCHAR(30), tour_info VARCHAR(250), " +
                "start_date VARCHAR(15), end_date VARCHAR(15), price DEC(7, 2), order_tour VARCHAR(50))";

        try (Connection dbConnection = getDBConnection();
             Statement statement = dbConnection.createStatement()) {
            System.out.println(createTableSQL);
            statement.execute(createTableSQL);
            System.out.println("Table users is creates!");
        } catch (SQLException e) {
            System.out.println(4);
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            createUserTable();
        } catch (SQLException e) {
            System.out.println(5);
            System.out.println(e.getMessage());
        }
    }

}
