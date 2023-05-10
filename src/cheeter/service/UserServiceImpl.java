package cheeter.service;

import cheeter.dto.requests.RegisterUserRequest;
import cheeter.data.models.User;
import cheeter.data.repositories.UserRepository;
import cheeter.dto.response.RegisterUserResponse;
import cheeter.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    public RegisterUserResponse registerNewUser(RegisterUserRequest request) {
        User user = Mapper.map(request);
        System.out.println(userRepository);
       User savedUser = userRepository.save(user);

       return Mapper.map(savedUser);
    }

    public User findUser(String id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new IllegalArgumentException("User does not exist");
        return user.get();
    }

}
