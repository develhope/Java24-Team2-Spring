package co.develhope.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class ArticleValuation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date datePublication;
    @Column(nullable = false)
    private int rating;

    public ArticleValuation(Long id, int rating) {
    }


//    @OneToOne(fetch =FetchType.LAZY)
//    @JoinColumn(name="articles_id")
//    private Articles articles;



}
