package com.straylense.benchsecurewebapp;

import com.straylense.benchsecurewebapp.model.UserCreationDTO;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping("/create")
    public ModelAndView getCreateUserForm() {
        return new ModelAndView("newuserform", "userCreationDTO", new UserCreationDTO());
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@ModelAttribute("UserCreationDTO")UserCreationDTO userCreationDTO,
                                   BindingResult bindingResult, ModelMap modelMap) {




        ModelAndView mav = new ModelAndView("newusercreated");
        return mav;
    }

}
