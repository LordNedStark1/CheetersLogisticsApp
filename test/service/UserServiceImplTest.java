package service;

import cheeter.data.models.User;
import cheeter.dto.requests.RegisterUserRequest;
import cheeter.dto.response.RegisterUserResponse;
import cheeter.service.UserService;
import cheeter.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService = new UserServiceImpl();
    }

    @Test
    public void registerUserTest(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setPhoneNumber("07064591358");
        request.setLastName("Udousoro");
        request.setFirstName("Inem");
        request.setAddress("address");
        request.setEmail("enamesit@gmail.com");

        RegisterUserResponse registerUserResponse = userService.registerNewUser(request);

        assertEquals(1, registerUserResponse.getId());
        User foundUser = userService.findUser("");
//        assertEquals(user, foundUser);
//        assertSame(registerUserResponse, foundUser);
//        System.out.println(foundUser);
    }

}