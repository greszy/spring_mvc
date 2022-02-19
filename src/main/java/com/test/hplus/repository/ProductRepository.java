package com.test.hplus.repository;

import com.test.hplus.beans.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    //This is an example of a custom query in Spring Data JPA.
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    public List<Product> searchByName(@Param("name") String name);

}
