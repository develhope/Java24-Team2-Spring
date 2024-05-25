package co.develhope.spring.controllers;

import co.develhope.spring.entities.UserDetails;
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
    public ResponseEntity<?> getUserDetailsById(@PathVariable Long id) {
        try {
            UserDetails userDetails = userDetailService.getUserDetailsById(id);
            return ResponseEntity.ok(userDetails);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createUserDetails(@Valid @RequestBody UserDetails userDetails, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            UserDetails createdUserDetails = userDetailService.createUserDetails(userDetails);
            return ResponseEntity.ok(createdUserDetails);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserDetails(@Valid @RequestBody UserDetails userDetails, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            UserDetails updatedUserDetails = userDetailService.updateUserDetails(userDetails, id);
            return ResponseEntity.ok(updatedUserDetails);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserDetailsById(@PathVariable Long id) {
        try {
            userDetailService.deleteUserDetailsById(id);
            return ResponseEntity.ok("User details deleted");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
