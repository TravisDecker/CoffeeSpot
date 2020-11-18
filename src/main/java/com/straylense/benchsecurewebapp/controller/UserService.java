package com.straylense.benchsecurewebapp.controller;

import com.straylense.benchsecurewebapp.NotFoundException;
import com.straylense.benchsecurewebapp.model.User;
import com.straylense.benchsecurewebapp.model.UserUserViewMapper;
import com.straylense.benchsecurewebapp.model.dtos.UserView;
import com.straylense.benchsecurewebapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserUserViewMapper userUserViewMapper;

    public List<UserView> getViewUsersByUsername(String userName) {
        return userRepository.findAllByUsernameContainingIgnoreCase(userName).stream()
                .map(userUserViewMapper::mapUserToUserView)
                .collect(Collectors.toList());
    }

    public User getUserByUserName(String userName) throws NotFoundException {
        Optional<User> user = userRepository.findByUsername(userName);

        return user.get();

        //return userRepository.findByUsername(userName).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
