package com.straylense.benchsecurewebapp.viewcontroller;

import com.straylense.benchsecurewebapp.controller.UserSearchService;
import com.straylense.benchsecurewebapp.model.dtos.UserView;
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
    UserSearchService userSearchService;

    @GetMapping
    public List<UserView> findUsersByUserName(@RequestParam(name = "username") String userName) {
        return userSearchService.getUsersByUsername(userName);
    }
}
