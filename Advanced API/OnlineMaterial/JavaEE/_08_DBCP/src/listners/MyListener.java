package listners;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("context intilazed");
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/apptwo");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("1234");
        basicDataSource.setMaxTotal(5);//how many connections
        basicDataSource.setInitialSize(5);// how many connection we should initialized

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("bds",basicDataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context Destroy");
    }
}
