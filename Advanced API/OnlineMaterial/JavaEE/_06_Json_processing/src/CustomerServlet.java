import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("name","Dilshaan");
        objectBuilder.add("age","24");
//        JsonObject build = objectBuilder.build();
        resp.setContentType("application/json");


        PrintWriter writer = resp.getWriter();
//        writer.print(build);

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonArrayBuilder add = arrayBuilder.add(objectBuilder);
        writer.print(add.build());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is the put method");
        String id = req.getParameter("id");
        String name = req.getParameter("name");

        String contentType = req.getContentType();
        System.out.println("content type "+contentType);

        JsonReader reader = Json.createReader(req.getReader());
        JsonObject jsonObject = reader.readObject();
        String string = jsonObject.getString("id");
        String string1 = jsonObject.getString("name");

        System.out.println("using json api = " +string+" "+string1);


        ServletInputStream inputStream = req.getInputStream();

        int data;
        while ((data = inputStream.read()) != -1){

            System.out.print((char)data);

        }

    }
}