package dev.araz.exception;

public class UserExistsException extends RuntimeException {
    public UserExistsException() {
        super("User with this name was created!!!");
    }
}
