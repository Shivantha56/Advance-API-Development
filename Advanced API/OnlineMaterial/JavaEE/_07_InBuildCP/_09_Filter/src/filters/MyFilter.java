package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/item")
public class MyFilter implements Filter {

    public MyFilter(){
         System.out.println("My filter is object ctrated");
     }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("My filter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("1 do filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("2 do filter");
    }

    @Override
    public void destroy() {
        System.out.println("filter is destroy");
    }
}
