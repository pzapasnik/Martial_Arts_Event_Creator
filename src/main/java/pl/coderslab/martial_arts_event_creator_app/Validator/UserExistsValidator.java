package pl.coderslab.martial_arts_event_creator_app.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.martial_arts_event_creator_app.Repository.UserRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class UserExistsValidator  implements ConstraintValidator<UserExists, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UserExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        try {
                if (userRepository.existsByEmail(email)) {
                    return false;
                } else {
                    return true;
                }
            } catch (NullPointerException e) {
                    return true;
        }
    }
}
