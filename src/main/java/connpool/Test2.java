package connpool;

import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.Connection;

@WebServlet ("/test21")
public class Test2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InitialContext initContext = new InitialContext();
            DataSource dataSource = (DataSource) initContext.lookup("java:comp/env/connpool");
            Connection con1 = dataSource.getConnection();
           // con1.close();
            System.out.println("HERE");
            Connection con2 = dataSource.getConnection();

            

        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
