package co.develhope.spring.services;

import co.develhope.spring.dtos.UserDetailsDto;

public interface UserDetailService {


    UserDetailsDto getUserDetailsById(Long id);

    UserDetailsDto createUserDetails(UserDetailsDto userDetailsDto);

    UserDetailsDto updateUserDetails(UserDetailsDto userDetailsDto, Long id);

    void deleteUserDetailsById(Long id);

}
