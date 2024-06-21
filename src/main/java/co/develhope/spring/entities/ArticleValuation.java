package co.develhope.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "rating", "articles_id" })})
@AllArgsConstructor
@NoArgsConstructor
public class ArticleValuation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date datePublication;

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private short rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="articles_id")
    @JsonBackReference(value = "article-articleValuation")
    private Article articles;
}
