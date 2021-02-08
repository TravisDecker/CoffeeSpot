package com.straylense.benchsecurewebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth/coffeepost/comment")
public class CommentController {

    @Autowired
    private UserService userService;
}
