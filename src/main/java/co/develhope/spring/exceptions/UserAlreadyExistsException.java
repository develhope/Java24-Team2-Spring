package co.develhope.spring.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class UserAlreadyExistsException extends DataIntegrityViolationException {
    public UserAlreadyExistsException(String s) {
        super(s);
    }
}
