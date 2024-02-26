package ru.artemkolosov.springboot_3_1_2.dao;

import ru.artemkolosov.springboot_3_1_2.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}