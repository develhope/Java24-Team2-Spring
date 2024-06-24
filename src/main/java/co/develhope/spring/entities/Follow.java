package co.develhope.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="follows")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFollow;

    @ManyToOne
    @JoinColumn(name = "followerId", nullable = false)
    @JsonBackReference(value = "user-follow")
    private User follower;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @JsonBackReference(value = "follow-user")
    private User user;

    @Column(nullable = false)
    private Date date;
}
