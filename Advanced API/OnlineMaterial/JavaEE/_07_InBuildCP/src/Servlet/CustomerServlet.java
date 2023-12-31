package Servlet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {


    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource dataSource;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
//            connection.prepareStatement("").executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
