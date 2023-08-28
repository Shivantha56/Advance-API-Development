import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

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
