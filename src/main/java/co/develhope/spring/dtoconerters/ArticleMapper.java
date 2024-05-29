package co.develhope.spring.dtoconerters;

import co.develhope.spring.dtos.ArticlesDTO;
import co.develhope.spring.entities.Articles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ArticlesDTO toDTO(Articles articles) {
        return modelMapper.map(articles, ArticlesDTO.class);
    }


    public Articles toEntity(ArticlesDTO articlesDTO) {
        return modelMapper.map(articlesDTO, Articles.class);
    }
}
