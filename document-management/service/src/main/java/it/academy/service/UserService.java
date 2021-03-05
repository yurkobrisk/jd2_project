package it.academy.service;

import it.academy.model.User;

import java.util.List;

public interface UserService {

    List<User> readAllUsers();

    User readUser(String id);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(String id);
}
