package co.develhope.spring.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class FollowDto {

    private Long idFollow;

    private Long followerId;

    private Long userId;

    private Date date;
}
