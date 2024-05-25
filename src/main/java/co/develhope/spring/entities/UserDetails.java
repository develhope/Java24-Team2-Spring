package co.develhope.spring.entities;

import co.develhope.spring.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @NotNull
    @Size(min= 2, max=50)
    private String firstName;

    @Column(nullable = false)
    @NotBlank
    @NotNull
    @Size(min=2,max=50)
    private String lastName;

    @Column
    @NotBlank
    @Size(min=5, max=100)
    private String city;

    @Column
    @NotBlank
    private LocalDate birthday;

    @Column(nullable = false)
    @NotBlank
    @NotNull
    private LocalDate signUpDate;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
