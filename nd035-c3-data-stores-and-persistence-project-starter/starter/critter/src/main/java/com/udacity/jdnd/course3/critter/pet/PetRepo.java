package com.udacity.jdnd.course3.critter.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<Pet,Long> {

    @Query(value = "select p from Pet as p join Customer as c on c.id = p.customer.id where p.customer.id = :ownerId")
    List<Pet> getByOwnerId(@RequestParam("ownerId") Long ownerId);
}
 