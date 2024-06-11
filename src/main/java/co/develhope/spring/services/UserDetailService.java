package co.develhope.spring.services;

import co.develhope.spring.dtos.UserDetailsDto;

import java.util.UUID;

public interface UserDetailService {

    UserDetailsDto getUserDetailsByUserId(UUID userId);

    UserDetailsDto createUserDetails(UserDetailsDto userDetailsDto, UUID userId);

    UserDetailsDto updateUserDetailsForUser(UUID userId, UserDetailsDto userDetailsDto);

    void deleteUserDetailsById(UUID id);
}
