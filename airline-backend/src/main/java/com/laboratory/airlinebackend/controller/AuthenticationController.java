package com.laboratory.airlinebackend.controller;

import com.laboratory.airlinebackend.controller.DTO.AuthenticationRequest;
import com.laboratory.airlinebackend.controller.DTO.AuthenticationResponse;
import com.laboratory.airlinebackend.controller.DTO.RegisterRequest;
import com.laboratory.airlinebackend.controller.exceptions.EmailAlreadyTakenException;
import com.laboratory.airlinebackend.controller.service.AuthenticationService;
import com.laboratory.airlinebackend.model.Permission;
import com.laboratory.airlinebackend.model.Role;
import com.laboratory.airlinebackend.model.RolePermission;
import com.laboratory.airlinebackend.model.User;
import com.laboratory.airlinebackend.repository.RolePermissionRepository;
import com.laboratory.airlinebackend.repository.RoleRepository;
import com.laboratory.airlinebackend.repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @PostMapping("/dummy")
    public ResponseEntity<?> getDummy(
            @RequestBody AuthenticationRequest dummyRequest
    ) {
        return ResponseEntity.ok(dummyRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }

    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ResponseEntity<String> handleEmailAlreadyTakenException(EmailAlreadyTakenException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Use an appropriate HTTP status code
                .body("Email address is already taken."); // Provide an error message
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> handleExpiredJwtExceptionException(ExpiredJwtException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Use an appropriate HTTP status code
                .body("Your JWT token has expired."); // Provide an error message
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){

        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/demo")
    public ResponseEntity<?> getClientAndPermissions01() {
        // 1. Get the client named Valentin
            User u = userRepository.findByFirstName("Pietro");

        if (u == null) {
            return ResponseEntity.notFound().build();
        }

        // 2. Get Valentin's role
        Role userRole = roleRepository.findById((long) u.getRole()).orElse(null);

        if (userRole == null) {
            return ResponseEntity.notFound().build();
        }

        // 3. Get the permissions associated with Valentin's role
        List<RolePermission> rolePermissions = rolePermissionRepository.findByRole(userRole);

        List<Permission> permissions = rolePermissions.stream()
                .map(RolePermission::getPermission)
                .collect(Collectors.toList());

        Map<String, Object> result = new HashMap<>();
        result.put("user", u);


        return ResponseEntity.ok(result);
    }



}
