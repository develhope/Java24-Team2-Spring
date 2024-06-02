package co.develhope.spring.controllers;

import co.develhope.spring.dtos.UserDetailsDto;
import co.develhope.spring.services.UserDetailService;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<?> getUserDetailsById(@PathVariable Long id) {
        try {
            UserDetailsDto userDetails = userDetailService.getUserDetailsById(id);
            userDetails.setAddress(null);
            return ResponseEntity.ok(userDetails);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createUserDetails(@Valid @RequestBody UserDetailsDto userDetailsDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            UserDetailsDto createdUserDetails = userDetailService.createUserDetails(userDetailsDto);
            createdUserDetails.setAddress(null);
            return ResponseEntity.ok(createdUserDetails);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserDetails(@Valid @RequestBody UserDetailsDto userDetailsDto, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            UserDetailsDto updatedUserDetails = userDetailService.updateUserDetails(userDetailsDto, id);
            return ResponseEntity.ok(updatedUserDetails);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDetailsById(@PathVariable Long id) {
        try {
            userDetailService.deleteUserDetailsById(id);
            return ResponseEntity.ok("User details deleted");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
