package com.straylense.benchsecurewebapp.model.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserView {
    private String userName;
    private String firstName;
    private String lastName;
}
