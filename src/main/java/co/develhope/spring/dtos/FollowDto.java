package co.develhope.spring.dtos;

import co.develhope.spring.entities.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FollowDto {

    private Long idFollow;
    private User follower;
    private User user;
    private LocalDateTime dataOra;
}
