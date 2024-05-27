package com.develhope.spring.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class ILike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "CommentId")
    private Comment comment;
    private LocalDateTime DateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public static void setComment(Comment comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateTime() {
        return DateTime;
    }

    public static void setDateTime(LocalDateTime dateTime) {
        DateTime = dateTime;
    }
}
