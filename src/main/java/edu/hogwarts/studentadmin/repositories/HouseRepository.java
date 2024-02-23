package edu.hogwarts.studentadmin.repositories;

import edu.hogwarts.studentadmin.models.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, String> {

    List<House> findByName(String name);

}
