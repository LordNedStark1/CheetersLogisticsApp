package cheeter.utils;

import cheeter.dto.requests.RegisterUserRequest;
import cheeter.dto.response.RegisterUserResponse;
import cheeter.data.models.User;

public class Mapper {
    public static User map(RegisterUserRequest request){
        User newUser = new User();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setAddress(request.getAddress());
        newUser.setPhoneNumber(request.getPhoneNumber());

        return newUser;
    }

    public static RegisterUserResponse map(User savedUser) {

        RegisterUserResponse response = new RegisterUserResponse();
        response.setId(savedUser.getId());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());


        return response;
    }
}
