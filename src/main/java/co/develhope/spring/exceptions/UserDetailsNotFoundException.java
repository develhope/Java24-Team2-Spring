package co.develhope.spring.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class UserDetailsNotFoundException extends EntityNotFoundException {
    public UserDetailsNotFoundException(String message) {
        super(message);
    }
}
