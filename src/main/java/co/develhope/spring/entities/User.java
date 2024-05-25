package co.develhope.spring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Size(min=6,max=50)
    private String email;

    @Column(name= "username",nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Size(min=5, max=20)
    private String username;

    @Column(name="password", nullable=false, unique = true)
    @NotNull
    @NotBlank
    @Size(min=8,max=100)
    private String password;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_details")
    private UserDetails userDetails;
}
