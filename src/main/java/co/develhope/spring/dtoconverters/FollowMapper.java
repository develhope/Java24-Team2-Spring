package co.develhope.spring.dtoconverters;

import co.develhope.spring.dtos.FollowDto;
import co.develhope.spring.entities.Follow;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowMapper {

    @Autowired
    private ModelMapper modelMapper;

    public FollowDto toDTO(Follow follow) {
        return modelMapper.map(follow, FollowDto.class);
    }

    public Follow toEntity(FollowDto followDto) {
        return modelMapper.map(followDto, Follow.class);
    }
}
