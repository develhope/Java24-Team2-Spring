package co.develhope.spring.dtos;

import co.develhope.spring.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
@Getter
@Setter
public class UserDetailsDto {
        @NotBlank
        @NotNull
        @Size(min= 2, max=50)
        private String firstName;

        @NotBlank
        @NotNull
        @Size(min=2,max=50)
        private String lastName;

        @NotBlank
        @Size(min=5, max=100)
        private String address;

        @NotBlank
        private LocalDate birthday;

        @NotNull
        @Enumerated(EnumType.STRING)
        private Gender gender;
    }


