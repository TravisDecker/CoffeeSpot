package com.straylense.benchsecurewebapp.viewcontroller;

import com.straylense.benchsecurewebapp.NotFoundException;
import com.straylense.benchsecurewebapp.model.CoffeePost;
import com.straylense.benchsecurewebapp.model.User;
import com.straylense.benchsecurewebapp.model.dtos.CoffeePostDto;
import com.straylense.benchsecurewebapp.repos.CoffeePostRepository;
import com.straylense.benchsecurewebapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/auth/feed")
public class FeedController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CoffeePostRepository coffeePostRepository;

    @GetMapping
    public ModelAndView getFeed(Principal principal) throws NotFoundException {
        User user = userRepository.findByUsername(principal.getName()).orElseThrow(() -> new NotFoundException("User Not Found"));
        List<User> feedUsers = user.getFriends();
        feedUsers.add(user);

        List<CoffeePost> feedPosts = coffeePostRepository.findAllByUserInOrderByDateTimePostedDesc(feedUsers);

        ModelAndView mav = new ModelAndView("feed", "coffeePostDto", new CoffeePostDto());
        mav.addObject("feedPosts", feedPosts);
        return mav;
    }
}
