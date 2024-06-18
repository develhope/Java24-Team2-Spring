package co.develhope.spring.services;

import co.develhope.spring.dtoconverters.UserMapper;
import co.develhope.spring.dtos.UserDto;
import co.develhope.spring.entities.User;
import co.develhope.spring.exceptions.UserAlreadyExistsException;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDto createUser(UserDto userDTO) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(userDTO.getUsername()));
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }
        User user = userMapper.toEntity(userDTO);
        if (userDTO.getUserDetails() != null) {
            user.setUserDetails(userDTO.getUserDetails());
        }
        User savedUser = userRepository.saveAndFlush(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        if (userDto.getUserDetails() != null) {
            user.setUserDetails(userDto.getUserDetails());
        }
        User updatedUser = userRepository.saveAndFlush(user);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User to delete not found");
        }
    }
}
