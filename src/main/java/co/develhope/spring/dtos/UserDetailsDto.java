package co.develhope.spring.dtos;

import co.develhope.spring.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDetailsDto {

        private Long id;

        @NotBlank(message = "First Name cannot be blank")
        @Size(min= 2, max=50)
        private String firstName;

        @NotBlank(message = "Last name cannot be blank")
        @Size(min=2,max=50)
        private String lastName;

        @NotBlank(message = "Address cannot be blank")
        @Size(min=5, max=100)
        private String address;

        @JsonFormat(pattern = "dd-MM-yyyy")
        @Past(message = "You cannot be born in the future!")
        private LocalDate birthday;

        @Enumerated(EnumType.STRING)
        private Gender gender;
    }


