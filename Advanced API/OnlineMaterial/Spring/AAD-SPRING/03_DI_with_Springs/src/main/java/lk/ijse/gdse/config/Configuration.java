package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.Boy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
@ComponentScan(basePackageClasses = Boy.class)
@org.springframework.context.annotation.Configuration
public class Configuration {
}
