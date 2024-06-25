package co.develhope.spring.services;

import co.develhope.spring.dtos.UserDetailsDto;

public interface UserDetailService {

    UserDetailsDto getUserDetailsByUserId(Long userId);

    UserDetailsDto createUserDetails(UserDetailsDto userDetailsDto,Long userId);

    UserDetailsDto updateUserDetailsForUser(Long userId, UserDetailsDto userDetailsDto);

    void deleteUserDetailsById(Long id);
}
