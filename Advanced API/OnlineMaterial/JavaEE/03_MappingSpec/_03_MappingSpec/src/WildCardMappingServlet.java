import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//example for wildcard mapping - item/I001/I002
@WebServlet(urlPatterns = "/items/*")
public class WildCardMappingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("wildcard mapping spec involved");
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();
        String contextPath = req.getContextPath();
        String method = req.getMethod();

        System.out.println("=================================");
        System.out.println("whilecard mapping invoke");
        System.out.println("servletpath info - "+servletPath);
        System.out.println("pathInfo - "+pathInfo);
        System.out.println("context path - "+ contextPath);
        System.out.println("method - "+ method);
        System.out.println("=================================");

    }
}
