package lk.ijse.gdse.repository;

import lk.ijse.gdse.config.JPAConfig;
import lk.ijse.gdse.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
class CustomerRepTest {
    @Autowired
    CustomerRep customerRep;

    @Test
    public void saveCustomer(){
        Customer customer = new Customer("1","2","3","4");
        customerRep.save(customer);
    }

}