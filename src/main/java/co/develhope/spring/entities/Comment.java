package co.develhope.spring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table
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

//    @OneToOne
//    private User user;
    // decommentare quando viene creata la classe User

//    @OneToOne
//    private Article article;
    // decommentare quando viene creata la classe Article


    public Comment(String text) {
        this.text = text;
        this.dateTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
