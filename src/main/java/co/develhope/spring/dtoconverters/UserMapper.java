package co.develhope.spring.dtoconverters;

import co.develhope.spring.dtos.UserDto;
import co.develhope.spring.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserDto toDTO(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User toEntity(UserDto userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
