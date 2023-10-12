package com.laboratory.airlinebackend.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.laboratory.airlinebackend.controller.DTO.AuthenticationRequest;
import com.laboratory.airlinebackend.controller.DTO.AuthenticationResponse;
import com.laboratory.airlinebackend.controller.DTO.RegisterRequestAdmin;
import com.laboratory.airlinebackend.controller.exceptions.EmailAlreadyTakenException;
import com.laboratory.airlinebackend.controller.service.AuthenticationService;
import com.laboratory.airlinebackend.model.User;
import com.laboratory.airlinebackend.repository.UserRepository;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class AdminController {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/listAdmins")
    public ResponseEntity<?> getAllAdministrators() {
        List<User> admins = userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == 2)
                .collect(Collectors.toList());

        return ResponseEntity.ok(admins);
    }

    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ResponseEntity<String> handleEmailAlreadyTakenException(EmailAlreadyTakenException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Use an appropriate HTTP status code
                .body("Email address is already taken."); // Provide an error message
    }

    @PostMapping("/newAdmin")
    public ResponseEntity<?> createNewAdmin(
            @RequestBody RegisterRequestAdmin requestNewAdmin
    ){
        String email = requestNewAdmin.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyTakenException("Email already exists");
        }

        requestNewAdmin.generateRandomPassword();

        var user = User.builder()
                .firstName(requestNewAdmin.getFirstName())
                .email(requestNewAdmin.getEmail())
                .role(2)
                .active(Boolean.TRUE)
                .password(passwordEncoder.encode(requestNewAdmin.getPassword()))
                .build();

        var savedUser = userRepository.save(user);
/*        return AuthenticationResponse.builder()
                .build();*/
        return ResponseEntity.ok("Administrador creado exitosamente");
    }

    @DeleteMapping("/deleteAdmin")
    public ResponseEntity<?> deleteAdmin(@RequestParam("id") Long adminId) {
        if (userRepository.existsById(adminId)) {
            userRepository.deleteById(adminId);
            return ResponseEntity.ok("Administrador eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin with ID " + adminId + " not found");
        }
    }

}
