package com.straylense.benchsecurewebapp.controller;

import com.straylense.benchsecurewebapp.model.CoffeePost;
import com.straylense.benchsecurewebapp.model.dtos.CoffeePostCreationDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;

@RestController(value = "/coffeepost")
public class CoffeePostController {

    @PostMapping
    public String createCoffeePost(@Valid @ModelAttribute("CoffeePostCreationDTO") CoffeePostCreationDTO coffeePostCreationDTO,
                                   BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            //TODO Handle error creating post
        }

        principal.getName();

        CoffeePost coffeePost = CoffeePost.builder()
                .user(null)
                .dateTimePosted(LocalDateTime.now())
                .postBody(coffeePostCreationDTO.getPostBody())
                .build();

        return "ok";
    }

}
