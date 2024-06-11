package co.develhope.spring.dtoconverters;

import co.develhope.spring.dtos.UserDetailsDto;
import co.develhope.spring.entities.UserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserDetailsDto toDTO(UserDetails userDetails) {
        return modelMapper.map(userDetails, UserDetailsDto.class);
    }

    public UserDetails toEntity(UserDetailsDto userDetailsDto) {
        return modelMapper.map(userDetailsDto, UserDetails.class);
    }
}

