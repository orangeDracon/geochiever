package com.orangedracon.geochiever.sql.user;

import com.orangedracon.geochiever.sql.user.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author orangeDracon
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserJDBCTemplate userJDBCTemplate;

    private static final String EMAIL_REGEX
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 24) {
            errors.rejectValue("username", "Size.registerForm.username");
        }

        User user2 = new User();
        try {
            user2 = userJDBCTemplate.getUserDataIfUserExists(user.getUsername());
        } catch (EmptyResultDataAccessException ex) {
            Logger.getLogger(UserValidator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserValidator.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (StringUtils.isNotBlank(user2.getUsername())) {
            errors.rejectValue("username", "Duplicate.registerForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (!user.getEmail().matches(EMAIL_REGEX)){
            errors.rejectValue("email", "Format.registerForm.email");
        }
        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 24) {
            errors.rejectValue("password", "Size.registerForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.registerForm.passwordConfirm");
        }
    }
}
