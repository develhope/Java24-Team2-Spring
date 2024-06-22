package co.develhope.spring.dtoconverters;

import co.develhope.spring.dtos.ArticleDTO;
import co.develhope.spring.dtos.LikeDto;
import co.develhope.spring.entities.Article;
import co.develhope.spring.entities.ILike;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeMapper {
    @Autowired
    private ModelMapper modelMapper;

    public LikeDto toDTO(ILike like) {
        return modelMapper.map(like, LikeDto.class);
    }

    public ILike toEntity(LikeDto likeDto) {
        return modelMapper.map(likeDto, ILike.class);
    }
}
