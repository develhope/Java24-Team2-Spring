package co.develhope.spring.services;

import co.develhope.spring.entities.User;
import co.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        Optional <User> optionalUser= userRepository.findById(id);
        if(optionalUser.isPresent()){
           User existUser = optionalUser.get();
           existUser.setEmail(user.getEmail());
           existUser.setUsername((user.getUsername()));
           existUser.setPassword(user.getPassword());
           existUser.setUserDetails(user.getUserDetails());
            return userRepository.saveAndFlush(existUser);
        }else{
            return null;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUser() {
    userRepository.deleteAll();
    }
}
