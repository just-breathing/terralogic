package assessment.terralogic.authentication.helpers;


import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import assessment.terralogic.authentication.entity.User;

@Component
public class validation implements Validator {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*\\d).*$");

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
            errors.rejectValue("password", "Password must have at least 1 capital letter, 1 special character, 1 number and be at least 10 characters long");
        }
    
    }


}
