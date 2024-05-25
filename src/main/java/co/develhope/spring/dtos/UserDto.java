package co.develhope.spring.dtos;

import co.develhope.spring.entities.UserDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;

    private String email;

    private String username;

    private UserDetails userDetails;
}
