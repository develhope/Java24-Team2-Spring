package co.develhope.spring.services;

import co.develhope.spring.entities.UserDetails;
import co.develhope.spring.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails getUserDetailsById(Long id) {
        return userDetailsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("UserDetails not found"));
    }

    @Override
    public UserDetails createUserDetails(UserDetails userDetails) {
        if (userDetails.getId() != null) {
            throw new IllegalArgumentException("User details already exist");
        }
        return userDetailsRepository.saveAndFlush(userDetails);
    }

    @Override
    public UserDetails updateUserDetails(UserDetails userDetails, Long id) {
        Optional <UserDetails> optionalUserDetails = userDetailsRepository.findById(id);
        if(optionalUserDetails.isPresent()){
            UserDetails newUserDetails = optionalUserDetails.get();
            newUserDetails.setFirstName(userDetails.getFirstName());
            newUserDetails.setLastName(userDetails.getCity());
            newUserDetails.setGender(userDetails.getGender());
            newUserDetails.setBirthday(userDetails.getBirthday());
            newUserDetails.setSignUpDate(userDetails.getSignUpDate());
            return userDetailsRepository.saveAndFlush(newUserDetails);
        }else{
            throw new IllegalArgumentException("User Details not found");
        }
    }
    @Override
    public void deleteUserDetailsById(Long id) {
        Optional<UserDetails> optionalUserDetails = userDetailsRepository.findById(id);
        if (optionalUserDetails.isPresent()) {
            userDetailsRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User details not found");
        }
    }
}
