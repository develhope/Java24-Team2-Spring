package co.develhope.spring.services;

import co.develhope.spring.dtoconverters.UserDetailsMapper;
import co.develhope.spring.dtos.UserDetailsDto;
import co.develhope.spring.entities.User;
import co.develhope.spring.entities.UserDetails;
import co.develhope.spring.exceptions.UserDetailsAlreadyExistException;
import co.develhope.spring.exceptions.UserDetailsNotFoundException;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.repositories.UserDetailsRepository;
import co.develhope.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Override
    public UserDetailsDto getUserDetailsByUserId(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        UserDetails userDetails = user.getUserDetails();
        if (userDetails == null) {
            throw new UserDetailsNotFoundException("User details not found");
        }
        return userDetailsMapper.toDTO(userDetails);
    }

    @Override
    public UserDetailsDto createUserDetails(UserDetailsDto userDetailsDto, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        if (user.getUserDetails() != null) {
            throw new UserDetailsAlreadyExistException("User details already exist");
        }
        UserDetails userDetails = userDetailsMapper.toEntity(userDetailsDto);
        user.setUserDetails(userDetails);
        userRepository.save(user);
        return userDetailsMapper.toDTO(userDetails);
    }

    @Override
    public UserDetailsDto updateUserDetailsForUser(UUID userId, UserDetailsDto userDetailsDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        UserDetails userDetails = user.getUserDetails();
        if (userDetails == null) {
            throw new UserDetailsNotFoundException("User details not found");
        }
        userDetailsRepository.save(userDetails);
        return userDetailsMapper.toDTO(userDetails);
    }

    @Override
    public void deleteUserDetailsById(UUID id) {
        Optional<UserDetails> optionalUserDetails = userDetailsRepository.findById(id);
        if (optionalUserDetails.isPresent()) {
            userDetailsRepository.deleteById(id);
        } else {
            throw new UserDetailsNotFoundException("User details not found");
        }
    }
}