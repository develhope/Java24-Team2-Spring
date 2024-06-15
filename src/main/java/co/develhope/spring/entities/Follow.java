package co.develhope.spring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFollow;

    @ManyToOne
    @JoinColumn(name = "followerId", nullable = false)
    private User follower; // Tieni i follower come già erano prima.

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user; // Sostituire 'followed' con 'user'

    @Column(nullable = false)
    private LocalDateTime dataOra;
}
