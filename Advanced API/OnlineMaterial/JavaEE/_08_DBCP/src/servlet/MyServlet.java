package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class MyServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        String dilshan = config.getInitParameter("Dilshan");
        System.out.println(dilshan);
    }

    public void init(){
        System.out.println("I am init method");

    }

    public MyServlet(){
        System.out.println("Mn servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("I am destroyer");
    }
}
