package cheeter.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class RegisterUserResponse {
    private String firstName;
    private String lastName;
    private String id;

}
