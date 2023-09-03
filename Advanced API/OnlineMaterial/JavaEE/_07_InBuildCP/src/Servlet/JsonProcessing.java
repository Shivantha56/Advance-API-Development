package Servlet;

import javax.annotation.Resource;
import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/customerApp")
public class JsonProcessing extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool") //adding resources in runtime
    DataSource dataSource; // if not use resource annotation the datasource become null

    //save customer
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

        try {
            String customerId = req.getParameter("customerId");
            String customerName = req.getParameter("customerName");
            String customerAddress = req.getParameter("customerAddress");
            double customerSalary = Double.parseDouble(req.getParameter("customerSalary"));
            System.out.println(customerId+ " " + customerName+" "+customerAddress+" "+customerSalary);

            Connection connection = dataSource.getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO customer (customer_id, customer_name, customer_address, customer_salary) VALUES (?, ?, ?, ?)");
            stm.setString(1,customerId);
            stm.setString(2,customerName);
            stm.setString(3,customerAddress);
            stm.setDouble(4,customerSalary);

            objectBuilder.add("customerId",customerId);
            objectBuilder.add("customerName",customerName);
            objectBuilder.add("customerAddress",customerAddress);
            objectBuilder.add("customerSalary",customerSalary);
            JsonObject jsonObject = objectBuilder.build();


            boolean save = stm.executeUpdate() > 0;


            if (save){
                resp.setContentType("application/json");
                PrintWriter writer = resp.getWriter();
                writer.print(jsonObject);
                System.out.println(jsonObject);
                System.out.println("customer saved");
            }else{
                PrintWriter writer = resp.getWriter();
                writer.write("Can not save customer");
                System.out.println("can not save customer");

            }

        } catch (SQLException e) {
            resp.setContentType("application/json");

            resp.setStatus(200);
            objectBuilder.add("status","500");
            objectBuilder.add("data","error");
            objectBuilder.add("message",e.getMessage());
            PrintWriter writer = resp.getWriter();
            writer.print(objectBuilder.build());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement stm = connection.prepareStatement("select * from customer");
            ResultSet resultSet = stm.executeQuery();



            if (resultSet.next()){

                String ids = resultSet.getString(1);
                String names = resultSet.getString(2);
                String addresss = resultSet.getString(3);
                String salarys= resultSet.getString(4);

                objectBuilder.add("status","200");
                objectBuilder.add("data","");
                objectBuilder.add("message","Customers fetch success");
                arrayBuilder.add(objectBuilder.build());

                //creating json array using json api
                objectBuilder.add("customerId",ids);
                objectBuilder.add("customerName",names);
                objectBuilder.add("customerAddress",addresss);
                objectBuilder.add("customerSalary",salarys);



                resp.setStatus(200);

                arrayBuilder.add(objectBuilder.build());

                while (resultSet.next()){
                    String id = resultSet.getString(1);
                    String name = resultSet.getString(2);
                    String address = resultSet.getString(3);
                    String salary = resultSet.getString(4);

                    //creating json array using json api
                    objectBuilder.add("customerId",id);
                    objectBuilder.add("customerName",name);
                    objectBuilder.add("customerAddress",address);
                    objectBuilder.add("customerSalary",salary);
                    arrayBuilder.add(objectBuilder.build());
                }

                resp.setContentType("application/json");
                PrintWriter writer = resp.getWriter();
                writer.print(arrayBuilder.build());
            }else {
                resp.setStatus(200);
                objectBuilder.add("status","400");
                objectBuilder.add("data","No customers found");
                objectBuilder.add("message","error");
                arrayBuilder.add(objectBuilder.build());

                resp.setContentType("application/json");
                PrintWriter writer = resp.getWriter();
                writer.print(arrayBuilder.build());
            }


        } catch (SQLException e) {
            resp.setContentType("application/json");

            resp.setStatus(200);
            objectBuilder.add("status","500");
            objectBuilder.add("data","error");
            objectBuilder.add("message",e.getMessage());
            PrintWriter writer = resp.getWriter();
            writer.print(objectBuilder.build());

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

        String getCustomerId = req.getParameter("customerId");
        System.out.println(getCustomerId);

        try {
            Connection connection = dataSource.getConnection();
            int delete = connection.createStatement().executeUpdate("DELETE FROM customer WHERE customer_id =\"" +getCustomerId+"\"");

            if (delete>0){
                System.out.println("customer delete");
            }else {
                System.out.println("Some thing happen");
            }




        } catch (SQLException e) {
            resp.setContentType("application/json");

            resp.setStatus(200);
            objectBuilder.add("status","500");
            objectBuilder.add("data","error");
            objectBuilder.add("message",e.getMessage());
            PrintWriter writer = resp.getWriter();
            writer.print(objectBuilder.build());
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        JsonReader reader = Json.createReader(req.getReader());
        JsonObject jsonObject = reader.readObject();
        String getCustomerId = jsonObject.getString("customerId");
        String customerName = jsonObject.getString("customerName");
        String customerAddress = jsonObject.getString("customerAddress");
        String salary = jsonObject.getString("customerSalary");
        double customerSalary = Double.parseDouble(salary);

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement stm = connection.prepareStatement("UPDATE customer SET customer_name = ?, customer_address = ?, customer_salary =? WHERE customer_id="+"\"" +getCustomerId+"\"");

            stm.setString(1,customerName);
            stm.setString(2,customerAddress);
            stm.setDouble(3,customerSalary);

            int i = stm.executeUpdate();



            if (i>0){

                resp.setStatus(200);
                objectBuilder.add("status","200");
                objectBuilder.add("data","customerUpdate success");
                objectBuilder.add("message","error");
                arrayBuilder.add(objectBuilder.build());

                PrintWriter writer = resp.getWriter();
                writer.print(arrayBuilder.build());
                System.out.println("customer updated");
            }else {
                System.out.println("cannot updated");
            }



        } catch (SQLException e) {
            resp.setContentType("application/json");

            resp.setStatus(200);
            objectBuilder.add("status","500");
            objectBuilder.add("data","error");
            objectBuilder.add("message",e.getMessage());
            PrintWriter writer = resp.getWriter();
            writer.print(objectBuilder.build());
        }


    }
}
