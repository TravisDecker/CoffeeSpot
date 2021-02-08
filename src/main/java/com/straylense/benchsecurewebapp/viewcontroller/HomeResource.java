package com.straylense.benchsecurewebapp.viewcontroller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@RestController
public class HomeResource {

    @GetMapping("/")
    public ModelAndView landing() {
        ModelAndView mav = new ModelAndView("landing");
        mav.addObject("date", LocalDate.now().toString());
        return mav;
    }

    @GetMapping("/main")
    public ModelAndView mian() {
        ModelAndView mav = new ModelAndView("feed");
        return mav;
    }

    @GetMapping("auth/user")
    public String user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return (String.format("<h1>Welcome %s</h1>", currentPrincipalName));
    }

    @GetMapping("/auth/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
