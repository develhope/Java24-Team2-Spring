package co.develhope.spring.dtos;

import co.develhope.spring.enums.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleDTO {

    private Long id;

    @NotNull(message = "Title cannot be null")
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 50)
    private String title;

    @NotNull(message = "Text cannot be null")
    @NotBlank(message = "Text cannot be blank")
    @Size(max = 50000)
    private String text;

    private String articleImage;

    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime postingDate;
}