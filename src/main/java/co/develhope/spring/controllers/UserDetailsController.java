package co.develhope.spring.controllers;

import co.develhope.spring.entities.UserDetails;
import co.develhope.spring.services.UserDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-details")
public class UserDetailsController {
    @Autowired
    UserDetailService userDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetailsById(@PathVariable Long id) {
        UserDetails userDetails = userDetailService.getUserDetailsById(id);
        if (userDetails != null) {
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User details not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> postUserDetails(@Valid @RequestBody UserDetails userDetails, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.hasErrors());
        } else {
            return ResponseEntity.ok(userDetailService.createUserDetails(userDetails));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserDetails(@Valid @RequestBody UserDetails userDetails, @PathVariable Long id,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(userDetailService.updateUserDetails(userDetails, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable Long id) {
        userDetailService.deleteUserDetailsById(id);
        return ResponseEntity.ok("User deleted");
    }
}
