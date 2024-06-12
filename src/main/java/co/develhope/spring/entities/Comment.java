package co.develhope.spring.entities;

import co.develhope.spring.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "comments")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "comment_text", nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    private String text;

    @Column(name = "comment_datetime")
    private Date dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-comment")
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    public String getUserName(){
        return this.user.getUsername();
    }
    // recupera id utente per mostrarlo nella get dei comment
}
