package co.develhope.spring.dtoconverters;

import co.develhope.spring.dtos.LikeDto;
import co.develhope.spring.entities.Like;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public LikeDto toDTO(Like like) {
        return modelMapper.map(like, LikeDto.class);
    }

    public Like toEntity(LikeDto likeDto) {
        return modelMapper.map(likeDto, Like.class);
    }
}
