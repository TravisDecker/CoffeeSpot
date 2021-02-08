package com.straylense.benchsecurewebapp.repos;

import com.straylense.benchsecurewebapp.model.CoffeePost;
import com.straylense.benchsecurewebapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    public List<Comment> findByPost(CoffeePost post);
}
