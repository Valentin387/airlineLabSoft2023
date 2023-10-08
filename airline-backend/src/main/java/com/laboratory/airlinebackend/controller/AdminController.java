package com.laboratory.airlinebackend.controller;

import com.laboratory.airlinebackend.model.User;
import com.laboratory.airlinebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/api/admin")
//@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class AdminController {

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


}
