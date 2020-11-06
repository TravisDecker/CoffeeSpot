package com.straylense.benchsecurewebapp;

import com.straylense.benchsecurewebapp.model.User;
import com.straylense.benchsecurewebapp.model.dtos.UserCreationDTO;
import com.straylense.benchsecurewebapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/signup")
public class SignUpController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ModelAndView getCreateUserForm() {
        return new ModelAndView("newuserform", "userCreationDTO", new UserCreationDTO());
    }

    @PostMapping
    public ModelAndView createUser(@Valid @ModelAttribute("UserCreationDTO") UserCreationDTO userCreationDTO,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("UserCreationDTO", bindingResult.getModel());
        }

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
