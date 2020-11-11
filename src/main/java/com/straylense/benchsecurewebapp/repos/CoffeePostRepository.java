package com.straylense.benchsecurewebapp.repos;

import com.straylense.benchsecurewebapp.model.CoffeePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoffeePostRepository extends JpaRepository<CoffeePost, UUID> {

}
