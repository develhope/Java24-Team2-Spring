package co.develhope.spring.services;

import co.develhope.spring.entities.UserDetails;


public interface UserDetailService {

    public UserDetails getUserDetailsById(Long id);

    public UserDetails createUserDetails(UserDetails userDetails);

    public UserDetails updateUserDetails(UserDetails userDetails, Long id);

    public void deleteUserDetailsById(Long id);

}
