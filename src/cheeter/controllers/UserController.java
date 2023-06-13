package cheeter.controllers;

import cheeter.data.models.User;
import cheeter.dto.requests.RegisterUserRequest;
import cheeter.dto.response.ApiResponse;
import cheeter.dto.response.RegisterUserResponse;
import cheeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cheeter.service.UserServiceImpl;


@RestController
public class UserController {
    @Autowired
    private UserService userService ;

    @PostMapping("/user")
    public ResponseEntity<?> registerNewUser(@RequestBody  RegisterUserRequest registerUserRequest){
        return new ResponseEntity<>(new ApiResponse(true ,userService.registerNewUser(registerUserRequest))
                , HttpStatus.CREATED);

    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(new ApiResponse(true, userService.findUser(id))
                    , HttpStatus.FOUND);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(new ApiResponse(false, ex.getMessage())
                    , HttpStatus.NOT_FOUND);
        }
    }
}
