package main.service;

import main.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User getUser(long id);

    List<User> getAllUsers();

    void updateUser(long id, User user);

    void deleteUser(long id);
}
