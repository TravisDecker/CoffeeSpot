package com.straylense.benchsecurewebapp.model;

import com.straylense.benchsecurewebapp.model.dtos.UserView;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserUserViewMapperTest {

    UserUserViewMapper userUserViewMapper = new UserUserViewMapper();

    @Test
    void testUserUserViewMapperReturnsExpected() {
        //Given
        EasyRandom random = new EasyRandom();
        User inputUser = random.nextObject(User.class);

        //When
        UserView actual = userUserViewMapper.mapUserToUserView(inputUser);

        //Then
        assertEquals(inputUser.getUsername(), actual.getUserName(), "Usernames should be equal");
        assertEquals(inputUser.getFirstName(), actual.getFirstName(), "First Names should be equal");
        assertEquals(inputUser.getLastName(), actual.getLastName(), "LastNames should be equal");
    }

}