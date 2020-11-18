package com.straylense.benchsecurewebapp.viewcontroller;

import com.straylense.benchsecurewebapp.NotFoundException;
import com.straylense.benchsecurewebapp.controller.UserService;
import com.straylense.benchsecurewebapp.model.User;
import com.straylense.benchsecurewebapp.model.dtos.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "auth/search")
public class UserSearchController {

    @Autowired
    UserService userService;

    @GetMapping
    public ModelAndView findUsersByUserName(@RequestParam(name = "username") String userName) {
        ModelAndView mav = new ModelAndView("usersearchpage");
        List<UserView> userViews = userService.getViewUsersByUsername(userName);
        mav.addObject("users", userViews);
        return mav;
    }

    @PostMapping
    public RedirectView addUserByUserName(@Valid @NotBlank @RequestParam("username") String username,
                                          Principal principal) throws NotFoundException {

        User user = userService.getUserByUserName(principal.getName());
        user.getFriends().add(userService.getUserByUserName(username));
        userService.saveUser(user);
        return new RedirectView("/auth/feed");
    }
}
