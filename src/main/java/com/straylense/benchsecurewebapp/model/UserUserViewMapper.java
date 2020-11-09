package com.straylense.benchsecurewebapp.model;

import com.straylense.benchsecurewebapp.model.dtos.UserView;
import org.springframework.stereotype.Component;

@Component
public class UserUserViewMapper {

    public UserView mapUserToUserView(User user) {
        return UserView.builder()
                .userName(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
