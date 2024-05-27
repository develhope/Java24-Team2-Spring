package co.develhope.spring.dtos;

import co.develhope.spring.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
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
        @NotBlank(message = "Il nome non può essere vuoto")
        @Size(min= 2, max=50)
        private String firstName;

        @NotBlank(message = "Il cognome non può essere vuoto")
        @Size(min=2,max=50)
        private String lastName;

        @NotBlank(message = "L'indirizzo non può essere vuoto")
        @Size(min=5, max=100)
        private String address;

        @NotBlank(message = "Questo campo non può essere vuoto")
        @JsonFormat(pattern = "dd-MM-yyyy")
        private LocalDate birthday;

        @NotNull(message="Questo campo non può essere nullo")
        @NotBlank(message = "Questo campo non può essere vuoto")
        @JsonFormat(pattern ="dd-MM-yyyy")
        private LocalDate signUpDate;

        @NotNull
        @Enumerated(EnumType.STRING)
        private Gender gender;
    }


