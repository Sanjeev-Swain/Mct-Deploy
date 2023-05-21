package com.example.MCTBlogging.dao;

import com.example.MCTBlogging.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {
    @Query(value = "Select * from post_table where post_id =:postId and status =1", nativeQuery = true)
    public List<Post> findByPostId(int postId);
}
