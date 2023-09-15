package lk.ijse.gdse.repository;

import lk.ijse.gdse.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRep extends JpaRepository<Customer,String> {


}
