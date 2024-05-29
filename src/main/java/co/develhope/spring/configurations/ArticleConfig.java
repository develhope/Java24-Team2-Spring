package co.develhope.spring.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleConfig {

        @Bean
        public ModelMapper modelMapperBean() {
            return new ModelMapper();
        }
}
