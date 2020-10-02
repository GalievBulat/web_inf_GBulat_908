package Servants;

import DBClasses.User;

import java.util.Optional;

public interface Auth {
    public Optional<User> authorise(String login, String password);
}
