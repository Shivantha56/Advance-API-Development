package lk.ijse.gdse.repository;

import lk.ijse.gdse.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {


}
