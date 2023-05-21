package com.example.MCTBlogging.dao;

import com.example.MCTBlogging.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "Select * from user_table where username = :userName", nativeQuery = true)
    public List<User> findUserByUserName(String userName);
}
