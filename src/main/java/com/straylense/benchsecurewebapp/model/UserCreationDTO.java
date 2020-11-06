package com.straylense.benchsecurewebapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Setter
@Getter
public class UserCreationDTO {
    @NonNull
    private String username = "username";

    @NonNull
    private String password = "password";

    @NonNull
    private String email = "email";

    private String firstName = "First Name";

    private String lastName = "Last Name";
}
