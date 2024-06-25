package co.develhope.spring.dtos;

import lombok.Data;

@Data
public class LikeDto {

    private Long id;

    private Long userId;

    private Long commentId;
}
