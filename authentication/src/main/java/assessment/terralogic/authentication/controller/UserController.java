package assessment.terralogic.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assessment.terralogic.authentication.entity.User;
import assessment.terralogic.authentication.entity.UserLogin;
import assessment.terralogic.authentication.entity.UserUpdate;
import assessment.terralogic.authentication.service.UserService;




@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/auth/login")    
    public  ResponseEntity<String> login (@RequestBody UserLogin requestBody) {

        return userService.login(requestBody);
    }
    
    @GetMapping("/all-users")
    public ResponseEntity<List<User>> getAllUsers( ) {
        return userService.getAllUsers();
    }
    
    @PostMapping("/update")
    public ResponseEntity<String> updateUsername(@RequestBody  UserUpdate requestBody) {
        return userService.updateUsername(requestBody);
    }
    
    @PostMapping("/auth/create-user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    
}
