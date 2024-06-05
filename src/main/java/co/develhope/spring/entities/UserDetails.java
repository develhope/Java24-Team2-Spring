package co.develhope.spring.entities;

import co.develhope.spring.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String address;

    @Column
    private LocalDate birthday;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
