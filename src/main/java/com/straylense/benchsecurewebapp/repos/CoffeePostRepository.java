package com.straylense.benchsecurewebapp.repos;

import com.straylense.benchsecurewebapp.model.CoffeePost;
import com.straylense.benchsecurewebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoffeePostRepository extends JpaRepository<CoffeePost, UUID> {

    public List<CoffeePost> findAllByUserInOrderByDateTimePostedDesc(List<User> users);
}
