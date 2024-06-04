package co.develhope.spring.dtos;

import co.develhope.spring.entities.Article;
import co.develhope.spring.entities.Comment;
import co.develhope.spring.entities.UserDetails;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {
    private Long id;

    @NotNull(message = "L'email non può essere nulla")
    @NotBlank(message = "L'email non può essere vuota")
    @Email(message = "Inserisci un indirizzo e-mail valido")
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

    @JsonFormat(pattern ="dd-MM-yyyy")
    private LocalDate signUpDate;

    private UserDetails userDetails;

    private List<Comment> comments;

    private List<Article> articles;
}
