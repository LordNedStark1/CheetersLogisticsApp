package cheeter;

import cheeter.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    private static UserController userController = new UserController(); ;

    public static void main(String... params) {
        SpringApplication.run(Main.class, params);
    }
}
