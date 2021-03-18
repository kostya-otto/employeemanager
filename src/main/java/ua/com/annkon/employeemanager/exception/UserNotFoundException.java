package ua.com.annkon.employeemanager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String messages) {
        super(messages);
    }
}
