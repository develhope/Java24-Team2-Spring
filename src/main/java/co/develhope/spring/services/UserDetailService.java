package co.develhope.spring.services;

import co.develhope.spring.dtos.UserDetailsDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserDetailService {

    UserDetailsDto getUserDetailsByUserId(Long userId);

    UserDetailsDto createUserDetails(UserDetailsDto userDetailsDto, Long userId, MultipartFile profileImage, String bucketName, String destinationFolderName);

    UserDetailsDto updateUserDetailsForUser(Long userId, UserDetailsDto userDetailsDto);

    void deleteUserDetailsById(Long id);
}
