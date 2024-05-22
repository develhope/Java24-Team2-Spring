package co.develhope.spring.entities;

import co.develhope.spring.models.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String address;

    @Column
    @NotBlank
    private LocalDate birthday;

    @Column(nullable = false)
    @NotBlank
    @NotNull
    private LocalDate signUpDate;

    @Column
    @NotBlank
    private Gender gender;
}
