package assessment.terralogic.authentication.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import assessment.terralogic.authentication.entity.User;
import assessment.terralogic.authentication.entity.UserLogin;
import assessment.terralogic.authentication.entity.UserUpdate;
import assessment.terralogic.authentication.helpers.validation;
import assessment.terralogic.authentication.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private validation validation;

    @Autowired
    private JwtService JWTService;

    @Autowired
    AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public ResponseEntity<String> createUser(User user) {
        try {
            Errors errors = new BeanPropertyBindingResult(user, "user");
            if (validation.supports(user.getClass())) {
                validation.validate(user, errors);
                if (errors.hasErrors()) {
                    return new ResponseEntity<>("User creation failed check password format, password must have at least 1 capital letter, 1 special character, 1 number and be at least 10 characters long", HttpStatus.NOT_ACCEPTABLE);
                }
            }
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("User creation failed", HttpStatus.NOT_ACCEPTABLE);
        }
  
    }

    public ResponseEntity<String> login(UserLogin user) {
            Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
            if (authentication.isAuthenticated()) {
                return new ResponseEntity<>( JWTService.generateToken(user.getUserName()), HttpStatus.OK);
            }    
            else {
                return new ResponseEntity<>("Bad Credentials", HttpStatus.NOT_ACCEPTABLE);
            }    
    }

 

    @Transactional
    public ResponseEntity<String> updateUsername(UserUpdate requestBody) {
        String newUsername = requestBody.getNewUserName();  
        String oldUsername = requestBody.getOldUserName();
        try {

            userRepository.updateUsername(oldUsername, newUsername);
            return new ResponseEntity<>("Username update successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Username update failed", HttpStatus.NOT_ACCEPTABLE);
        }

    }

  
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_ACCEPTABLE);
        }
    
    }
}
