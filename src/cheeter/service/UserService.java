package cheeter.service;

import cheeter.dto.requests.RegisterUserRequest;
import cheeter.dto.response.RegisterUserResponse;
import cheeter.data.models.User;

public interface UserService {
    RegisterUserResponse registerNewUser(RegisterUserRequest registerUserRequest);
    User findUser(String id);
}
