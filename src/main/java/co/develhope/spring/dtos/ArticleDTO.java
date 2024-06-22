package co.develhope.spring.dtos;

import co.develhope.spring.entities.ArticleValuation;
import co.develhope.spring.enums.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleDTO {

    private Long id;

    @NotNull(message = "Il titolo non può mancare!")
    @NotBlank(message = "Il titolo non può essere vuoto")
    @Size(max = 50)
    private String title;

    @NotNull(message = "Il testo non può mancare!")
    @NotBlank(message = "Il testo non può essere vuoto")
    @Size(max = 50000)
    private String text;

    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime postingDate;

    private List<ArticleValuation> articleValuations;
}