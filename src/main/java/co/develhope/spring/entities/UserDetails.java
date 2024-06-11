package co.develhope.spring.entities;

import co.develhope.spring.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name= "first_name",nullable = false)
    private String firstName;

    @Column(name= "last_name",nullable = false)
    private String lastName;

    @Column(name="address")
    private String address;

    @Column(name="birthday")
    private LocalDate birthday;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
