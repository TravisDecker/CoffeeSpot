package com.straylense.benchsecurewebapp.controller;

import com.straylense.benchsecurewebapp.NotFoundException;
import com.straylense.benchsecurewebapp.model.CoffeePost;
import com.straylense.benchsecurewebapp.model.User;
import com.straylense.benchsecurewebapp.model.dtos.CoffeePostDto;
import com.straylense.benchsecurewebapp.repos.CoffeePostRepository;
import com.straylense.benchsecurewebapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "auth/coffeepost")
public class CoffeePostController {

    @Autowired
    private CoffeePostRepository coffeePostRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView createCoffeePost() {
        ModelAndView mav = new ModelAndView("createcoffeepost", "coffeePostDto", new CoffeePostDto());
        return mav;
    }

    @Transactional
    @PostMapping
    public RedirectView createCoffeePost(@Valid @ModelAttribute("CoffeePostDto") CoffeePostDto coffeePostDto,
                                         BindingResult bindingResult, Principal principal) throws NotFoundException {
        if (bindingResult.hasErrors()) {
            //TODO Handle error creating post
        }
        User user = userRepository.findByUsername(principal.getName()).orElseThrow(() -> new NotFoundException("User not found"));


        CoffeePost coffeePost = CoffeePost.builder()
                .dateTimePosted(LocalDateTime.now())
                .postBody(coffeePostDto.getBody())
                .build();
        CoffeePost savedCoffeePost = coffeePostRepository.save(coffeePost);

        List<CoffeePost> coffeePostList = user.getPosts();
        coffeePostList.add(savedCoffeePost);
        user.setPosts(coffeePostList);

        userRepository.save(user);

        return new RedirectView("/auth/feed");
    }

}
