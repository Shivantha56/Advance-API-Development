package servlet;

import com.mysql.cj.xdevapi.JsonArray;
import to.CustomerTo;

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
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    String jdbcUrl = "jdbc:mysql://localhost:3306/testApi";
    String username = "root";
    String password = "1234";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ArrayList<JsonArray>
        try {
            System.out.println("Enter");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            ResultSet resultSet = connection.prepareStatement("SELECT * FROM customer").executeQuery();

            String addJson ="";

            while (resultSet.next()) {
                String customerID = resultSet.getString(1);
                String fName = resultSet.getString(2);
                String lName = resultSet.getString(3);
                String email = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String birthday = resultSet.getString(6);
                String regDate = resultSet.getString(7);

                System.out.println(customerID+" "+fName+" "+lName+" "+email);

                resp.setContentType("application/json");
                PrintWriter writer = resp.getWriter();
                writer.write("");

                String json = "{\"fName\":\""+fName+"\",\"lName\":\""+lName+"\",\"email\":\""+email+"\"},";
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
