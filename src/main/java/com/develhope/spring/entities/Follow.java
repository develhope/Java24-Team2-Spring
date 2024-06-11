package com.develhope.spring.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFollow;

    @ManyToOne
    @JoinColumn(name = "idUtenteFollower", nullable = false)
    private User follower;

    @ManyToOne
    @JoinColumn(name = "idUtenteFollowed", nullable = false)
    private User followed;

    @Column(nullable = false)
    private LocalDateTime dataOra;

    public Long getIdFollow() {
        return idFollow;
    }

    public void setIdFollow(Long idFollow) {
        this.idFollow = idFollow;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }
}
