package co.develhope.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

//    private List<String> tags;

    @Column(nullable = false, length = 5000 )
    private String text;

    @Column(nullable = false)
    private Date postingDate;

    @Column(nullable = false)
    private Category category;




//    @ManyToOne(fetch =FetchType.LAZY)
//    @JoinColumn(name="user_id")
//    private User user;


//    @OneToOne(fetch =FetchType.LAZY)
//    @JoinColumn(name="articleValuationId")
//    private ArticleValuation articleValuation;




}
