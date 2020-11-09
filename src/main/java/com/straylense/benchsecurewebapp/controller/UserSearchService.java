package com.straylense.benchsecurewebapp.controller;

import com.straylense.benchsecurewebapp.model.UserUserViewMapper;
import com.straylense.benchsecurewebapp.model.dtos.UserView;
import com.straylense.benchsecurewebapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSearchService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserUserViewMapper userUserViewMapper;

    public List<UserView> getUsersByUsername(String userName) {
        return userRepository.findAllByUsernameContainingIgnoreCase(userName).stream()
                .map(userUserViewMapper::mapUserToUserView)
                .collect(Collectors.toList());
    }
}
