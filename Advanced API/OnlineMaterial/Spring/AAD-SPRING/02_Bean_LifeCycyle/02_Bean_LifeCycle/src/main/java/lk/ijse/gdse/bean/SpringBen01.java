package lk.ijse.gdse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//Bean scope
public class SpringBen01 implements DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

    public SpringBen01() {
        System.out.println("springBean 01 Initiated");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Bean name awareness call");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("bean factory aware call");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context awareness call");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initailizing bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean is destroyed");
    }
}
