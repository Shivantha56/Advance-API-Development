package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Wrapper;
import java.util.Map;

//@WebFilter(urlPatterns = {"/item", "/customer"})
@WebFilter(urlPatterns = "/*")
public class MyFilter extends HttpServlet implements Filter {

    HttpServletResponse httpServletResponse ;

    public MyFilter() {
        System.out.println("My filter is object ctrated");

    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("My filter initialized");


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {



        httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.addHeader("x","X");
        System.out.println("1 do filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("2 do filter");





    }

    @Override
    public void destroy() {
        System.out.println("filter is destroy");
    }
}
