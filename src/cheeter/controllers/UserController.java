package cheeter.controllers;

import cheeter.dto.requests.MyObjectRequest;
import cheeter.dto.requests.RegisterUserRequest;
import cheeter.dto.responses.ApiResponse;
import cheeter.dto.responses.RegisterUserResponse;
import cheeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping("/hospital")
    public String hospitalCall(@RequestBody MyObjectRequest myObject) {
        System.out.println(myObject);
        return "hospital";
    }
    @PostMapping("/register")
    public RegisterUserResponse registerUser(@RequestBody  RegisterUserRequest registerUserRequest){
        return userService.registerNewUser(registerUserRequest);

    }
}
