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

    @GetMapping("{id}")
    public ResponseEntity<UserDetails> getUserDetails(@PathVariable Long id) {
        return new ResponseEntity<>(userDetailService.getUserDetailsById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postUserDetails(@Valid @RequestBody UserDetails userDetails, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.hasErrors());
        } else {
            return ResponseEntity.ok(userDetailService.createUserDetails(userDetails));
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUserDetails(@Valid @RequestBody UserDetails userDetails, Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        UserDetails newUser = userDetailService.updateUserDetails(userDetails, id);
        if (newUser != null) {
            return ResponseEntity.ok(newUser);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable Long id) {
        userDetailService.deleteUserDetailsById(id);
        return ResponseEntity.noContent().build();
    }
}
