package com.test.hplus.repository;

import com.test.hplus.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User WHERE u.username= :name")
    public User searchByName(@Param("name") String userName);

}
