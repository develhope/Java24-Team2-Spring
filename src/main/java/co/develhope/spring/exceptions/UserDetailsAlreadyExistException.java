package co.develhope.spring.exceptions;

public class UserDetailsAlreadyExistException extends IllegalArgumentException {
    public UserDetailsAlreadyExistException(String s) {
        super(s);
    }
}
