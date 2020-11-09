package com.straylense.benchsecurewebapp.viewcontroller;

import com.straylense.benchsecurewebapp.model.User;
import com.straylense.benchsecurewebapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class UserSearchController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> findUsersByUserName(@RequestParam(name = "username") String userName) {
        return userRepository.findAllByUsernameContainingIgnoreCase(userName);

    }
}
