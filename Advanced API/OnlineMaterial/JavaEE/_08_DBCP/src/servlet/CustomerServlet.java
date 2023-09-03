package servlet;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/DBCP")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        basicDataSource.setUrl("jdbc:mysql://localhost:3306/apptwo");
//        basicDataSource.setUsername("root");
//        basicDataSource.setPassword("1234");
//        basicDataSource.setMaxTotal(5);//how many connections
//        basicDataSource.setInitialSize(5);// how many connection we should initialized

//        ServletContext servletContext = req.getServletContext();
//        servletContext.setAttribute("bds",basicDataSource);

        System.out.println("aaa");

        ServletContext servletContext = req.getServletContext();
        BasicDataSource basicDataSource = (BasicDataSource) servletContext.getAttribute("bds");

        try {
            Connection connection = basicDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String salary = resultSet.getString(4);
                System.out.println(id);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        BasicDataSource bds = (BasicDataSource) servletContext.getAttribute("bds");

        try {
            Connection connection = bds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String salary = resultSet.getString(4);
                System.out.println(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
