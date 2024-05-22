package co.develhope.spring.services;

import co.develhope.spring.entities.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(Long id);

    public User createUser(User user);

    public User updateUser (User user, Long id);

    public void deleteUserById(Long id);

    public void deleteAllUser();
}
