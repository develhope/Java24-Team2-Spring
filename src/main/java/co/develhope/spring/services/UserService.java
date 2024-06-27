package co.develhope.spring.services;

import co.develhope.spring.dtos.UserDto;

public interface UserService {

    UserDto getUserById(Long id);

    UserDto createUser(UserDto userDTO);

    UserDto updateUser (UserDto userDto, Long id);

    void deleteUserById(Long id);
}
