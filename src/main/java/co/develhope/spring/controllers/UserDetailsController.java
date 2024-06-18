package co.develhope.spring.controllers;

import co.develhope.spring.dtos.UserDetailsDto;
import co.develhope.spring.exceptions.UserDetailsAlreadyExistException;
import co.develhope.spring.exceptions.UserDetailsNotFoundException;
import co.develhope.spring.exceptions.UserNotFoundException;
import co.develhope.spring.services.UserDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-details")
public class UserDetailsController {
    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetailsByUserId(@PathVariable Long userId) {
        try {
            UserDetailsDto userDetails = userDetailService.getUserDetailsByUserId(userId);
            return ResponseEntity.ok(userDetails);
        } catch (UserDetailsNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> createUserDetails(@PathVariable Long userId, @Valid @RequestBody UserDetailsDto userDetailsDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            UserDetailsDto createdUserDetails = userDetailService.createUserDetails(userDetailsDto,userId);
            return ResponseEntity.ok(createdUserDetails);
        } catch (UserDetailsAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserDetails(@Valid @RequestBody UserDetailsDto userDetailsDto, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            UserDetailsDto updatedUserDetails = userDetailService.updateUserDetailsForUser(id,userDetailsDto);
            return ResponseEntity.ok(updatedUserDetails);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDetailsById(@PathVariable Long id) {
        try {
            userDetailService.deleteUserDetailsById(id);
            return ResponseEntity.ok("User details deleted");
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
