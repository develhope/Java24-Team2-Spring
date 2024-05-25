package com.develhope.spring.dtos;

import com.develhope.spring.entities.Category;

import java.util.Date;

public class ArticlesDTO {



    private Long id;
    private String title;
//    private List<String> tags;
    private String text;
    private Date postingDate;
    private Category category;

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
