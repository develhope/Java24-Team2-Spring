package co.develhope.spring.dtoconverters;

import co.develhope.spring.dtos.ArticleDTO;
import co.develhope.spring.entities.Article;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ArticleDTO toDTO(Article article) {
        return modelMapper.map(article, ArticleDTO.class);
    }


    public Article toEntity(ArticleDTO articleDTO) {
        return modelMapper.map(articleDTO, Article.class);
    }
}
