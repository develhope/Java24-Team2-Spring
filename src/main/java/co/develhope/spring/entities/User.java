package co.develhope.spring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Size(min=6,max=50)
    private String email;

    @Column(nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Size(min=5, max=20)
    private String username;

    @Column(nullable=false, unique = true)
    @NotNull
    @NotBlank
    @Size(min=8,max=100)
    private String password;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="user_details")
    private UserDetails userDetails;
}
