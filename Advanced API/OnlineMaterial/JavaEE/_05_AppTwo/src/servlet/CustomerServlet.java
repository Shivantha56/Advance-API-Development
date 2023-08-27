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
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customerss")
public class CustomerServlet extends HttpServlet {

    String jdbcUrl = "jdbc:mysql://localhost:3306/apptwo";
    String username = "root";
    String password = "1234";


    //save customer
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            String customerId = req.getParameter("customerId");
            String customerName = req.getParameter("customerName");
            String customerAddress = req.getParameter("customerAddress");
            double customerSalary = Double.parseDouble(req.getParameter("customerSalary"));
            System.out.println(customerId+ " " + customerName+" "+customerAddress+" "+customerSalary);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement stm = connection.prepareStatement("INSERT INTO customer (customer_id, customer_name, customer_address, customer_salary) VALUES (?, ?, ?, ?)");
            stm.setString(1,customerId);
            stm.setString(2,customerName);
            stm.setString(3,customerAddress);
            stm.setDouble(4,customerSalary);

            String finalJson = "{\"customerId\":\""+customerId+"\",\"customerName\":\""+customerName+"\",\"customerAddress\":\""+customerAddress+"\",\"customerSalary\":\""+customerSalary+"\"}";
            System.out.println(finalJson);


            boolean save = stm.executeUpdate() > 0;


            if (save){
                resp.setContentType("application/json");
                PrintWriter writer = resp.getWriter();
                writer.write(finalJson);
                System.out.println("customer saved");
            }else{
                PrintWriter writer = resp.getWriter();
                writer.write("Can not save customer");
                System.out.println("can not save customer");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
