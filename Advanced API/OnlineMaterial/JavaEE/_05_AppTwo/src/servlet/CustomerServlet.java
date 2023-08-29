package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String createJson = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement stm = connection.prepareStatement("select * from customer");
            ResultSet resultSet = stm.executeQuery();


            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String salary = resultSet.getString(4);


                String finalJson = "{\"customerId\":\""+id+"\",\"customerName\":\""+name+"\",\"customerAddress\":\""+address+"\",\"customerSalary\":\""+salary+"\"},";
                createJson += finalJson;
                System.out.println("result set"+id+name+address+salary);
            }

            String finalJson = "["+createJson.substring(0,createJson.length()-1)+"]";
            PrintWriter writer = resp.getWriter();
            writer.write(finalJson);


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String getCustomerId = req.getParameter("customerId");
        System.out.println(getCustomerId);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            int delete = connection.createStatement().executeUpdate("DELETE FROM customer WHERE customer_id =\"" +getCustomerId+"\"");
//            int delete = connection.prepareStatement("DELETE FROM customer WHERE customer_id ="+getCustomerId).executeUpdate();

            if (delete>0){
                System.out.println("customer delete");
            }else {
                System.out.println("Some thing happen");
            }




        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String getCustomerId = req.getParameter("customerId");
        String customerName = req.getParameter("customerName");
        String customerAddress = req.getParameter("customerAddress");
        double customerSalary = Double.parseDouble(req.getParameter("customerSalary"));
        System.out.println(getCustomerId+ " " + customerName+" "+customerAddress+" "+customerSalary);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement stm = connection.prepareStatement("UPDATE customer SET customer_name = ?, customer_address = ?, customer_salary =? WHERE customer_id="+"\"" +getCustomerId+"\"");

            stm.setString(1,customerName);
            stm.setString(2,customerAddress);
            stm.setDouble(3,customerSalary);

            int i = stm.executeUpdate();



            if (i>0){
//
                String finalJson = "{\"customerId\":\""+getCustomerId+"\",\"customerName\":\""+customerName+"\",\"customerAddress\":\""+customerAddress+"\",\"customerSalary\":\""+customerSalary+"\"}";

                PrintWriter writer = resp.getWriter();
                writer.write(finalJson);
                System.out.println("customer updated");
            }else {
                System.out.println("cannot updated");
            }



        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
