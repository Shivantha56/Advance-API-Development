package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {

    String jdbcUrl = "jdbc:mysql://localhost:3306/testApi";
    String username = "root";
    String password = "1234";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("Enter");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            ResultSet resultSet = connection.prepareStatement("SELECT * FROM items").executeQuery();

            String addJson ="";

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String price = resultSet.getString(5);

                resp.setContentType("application/json");
                PrintWriter writer = resp.getWriter();
                writer.write("");

                String json = "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"price\":\""+price+"\"},";
                addJson += json;
            }

            String finalJson ="["+addJson;
            finalJson =finalJson.substring(0,finalJson.length()-1)+"]";
            PrintWriter writer = resp.getWriter();
            writer.write(finalJson);

            System.out.println("finish");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
