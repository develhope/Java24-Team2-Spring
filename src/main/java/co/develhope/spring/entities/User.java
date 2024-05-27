package co.develhope.spring.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable=false, unique = true)
    private String password;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_details")
    private UserDetails userDetails;
}
