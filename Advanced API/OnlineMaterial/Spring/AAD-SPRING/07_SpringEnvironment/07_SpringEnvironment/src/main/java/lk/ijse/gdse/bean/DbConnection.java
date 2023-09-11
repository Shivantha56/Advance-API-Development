package lk.ijse.gdse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DbConnection implements InitializingBean {

    @Autowired
    Environment environment;

    @Value("${user.db.url}")
    private String url;
    @Value("${user.db.userName}")
    private String userName;
    @Value("${user.db.password}")
    private String password;
    @Value("${user.db.driverClassName}")
    private String driverClassName;

    public DbConnection() {
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(environment);
        System.out.println(environment.getProperty("user.db.url"));
        System.out.println(environment.getProperty("user.db.l"));

    }
}
