package com.straylense.benchsecurewebapp;

import com.straylense.benchsecurewebapp.model.User;
import com.straylense.benchsecurewebapp.model.UserCreationDTO;
import com.straylense.benchsecurewebapp.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/create")
    public ModelAndView getCreateUserForm() {
        return new ModelAndView("newuserform", "userCreationDTO", new UserCreationDTO());
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@Valid @ModelAttribute("UserCreationDTO") UserCreationDTO userCreationDTO,
                                   BindingResult bindingResult, ModelMap modelMap) {
        User newUser = User.builder()
                .username(userCreationDTO.getUsername())
                .password(userCreationDTO.getPassword())
                .email(userCreationDTO.getEmail())
                .firstName(userCreationDTO.getFirstName())
                .lastName(userCreationDTO.getLastName())
                .build();
            userRepository.save(newUser);

        ModelAndView mav = new ModelAndView("newusercreated");
        return mav;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
