package co.develhope.spring.services;

import co.develhope.spring.dtoconverters.UserDetailsMapper;
import co.develhope.spring.dtos.UserDetailsDto;
import co.develhope.spring.entities.UserDetails;
import co.develhope.spring.repositories.UserDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Override
    public UserDetailsDto getUserDetailsById(Long id) {
        UserDetails userDetails = userDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserDetails not found"));
        return userDetailsMapper.toDTO(userDetails);
    }

    @Override
    public UserDetailsDto createUserDetails(UserDetailsDto userDetailsDto) {
        UserDetails userDetails = userDetailsMapper.toEntity(userDetailsDto);
        if (userDetails.getId() != null) {
            throw new RuntimeException("User details already exist");
        }
        userDetails.setSignUpDate(LocalDate.now());
        UserDetails createdUserDetails = userDetailsRepository.saveAndFlush(userDetails);
        return userDetailsMapper.toDTO(createdUserDetails);
    }

    @Override
    public UserDetailsDto updateUserDetails(UserDetailsDto userDetailsDto, Long id) {
        UserDetails userDetails = userDetailsMapper.toEntity(userDetailsDto);
        Optional<UserDetails> optionalUserDetails = userDetailsRepository.findById(id);
        if (optionalUserDetails.isPresent()) {
            UserDetails newUserDetails = optionalUserDetails.get();
            newUserDetails.setFirstName(userDetails.getFirstName());
            newUserDetails.setLastName(userDetails.getLastName());
            newUserDetails.setGender(userDetails.getGender());
            newUserDetails.setBirthday(userDetails.getBirthday());
            newUserDetails.setAddress(userDetails.getAddress());
            UserDetails updatedUserDetails = userDetailsRepository.saveAndFlush(newUserDetails);
            return userDetailsMapper.toDTO(updatedUserDetails);
        } else {
            throw new EntityNotFoundException("User Details not found");
        }
    }

    @Override
    public void deleteUserDetailsById(Long id) {
        Optional<UserDetails> optionalUserDetails = userDetailsRepository.findById(id);
        if (optionalUserDetails.isPresent()) {
            userDetailsRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User details not found");
        }
    }
}
