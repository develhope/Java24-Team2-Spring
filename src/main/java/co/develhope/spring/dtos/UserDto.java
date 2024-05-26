package co.develhope.spring.dtos;

import co.develhope.spring.entities.UserDetails;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;

    @NotNull(message = "L'email non può essere nulla")
    @NotBlank(message = "L'email non può essere vuota")
    @Size(min = 6, max = 50)
    private String email;

    @NotNull(message = "Il nome utente non può essere nullo")
    @NotBlank(message = "Il nome utente non può essere vuoto")
    @Size(min = 5, max = 20)
    private String username;

    @NotNull(message = "La password non può essere nulla")
    @NotBlank(message = "La password non può essere vuota")
    @Size(min = 8, max = 100)
    private String password;

    private UserDetails userDetails;
}
