package co.develhope.spring.dtos;

import co.develhope.spring.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class ArticlesDTO {



    private Long id;


    @NotNull(message = "Il titolo non può essere null")
    @NotBlank(message = "Il titolo non può essere vuoto")
    @Size(max = 50)
    private String title;


//    private List<String> tags;

    @NotNull(message = "Il testo non può essere null")
    @NotBlank(message = "Il testo non può essere vuoto")
    private String text;


    private Date postingDate;


    private Category category;


    public ArticlesDTO() {
    }

    public ArticlesDTO(String txt, String title, Date postingDate, Category category, Long id) {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
