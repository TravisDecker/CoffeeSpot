package com.straylense.benchsecurewebapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UserCreationDTO {
    @NonNull
    private String username;

    @NonNull
    @Size(min = 8)
    private String password;

    @NonNull
    @Size(min = 8)
    private String confirmPassword;

    @NonNull
    @Email(message = "Email should be valid")
    private String email;

    private String firstName;

    private String lastName;
}
