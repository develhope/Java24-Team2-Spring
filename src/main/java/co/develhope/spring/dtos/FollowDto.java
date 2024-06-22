package co.develhope.spring.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FollowDto {

    private Long idFollow;

    private Long followerId;

    private Long userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}
