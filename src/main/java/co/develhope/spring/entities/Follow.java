package co.develhope.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="follows", uniqueConstraints = { @UniqueConstraint(columnNames = { "follower_id", "user_id",})})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFollow;

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    @JsonBackReference(value = "user-follow")
    private User follower;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference(value = "follow-user")
    private User user;

    @Column(nullable = false)
    private Date date;
}
