package co.develhope.spring.services;

import co.develhope.spring.dtos.UserDto;
import co.develhope.spring.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto getUserById(UUID id);

    UserDto createUser(UserDto userDTO);

    UserDto updateUser (UserDto userDto, UUID id);

    void deleteUserById(UUID id);
}
