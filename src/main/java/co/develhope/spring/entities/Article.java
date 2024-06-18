package co.develhope.spring.entities;

import co.develhope.spring.enums.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Table(name="articles")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;


    @Column(nullable = false, length = 5000)
    private String text;

    @Column(nullable = false)
    private Date postingDate;

    @Column(nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-article")
    private User user;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "article-comment")
    private List<Comment> comments;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "article_valuation")
    @JsonManagedReference(value = "article-articleValuation")
    private ArticleValuation articleValuation;

}
