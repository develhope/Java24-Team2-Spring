package co.develhope.spring.dtos;

import co.develhope.spring.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FollowDto {

    private Long idFollow;

    private User follower;

    private User user;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}
