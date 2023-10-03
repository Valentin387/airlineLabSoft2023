package com.laboratory.airlinebackend.controller;

import com.laboratory.airlinebackend.controller.DTO.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class AuthenticationController {

    @PostMapping("/dummy")
    public ResponseEntity<?> getDummy(
            @RequestBody AuthenticationRequest dummyRequest
    ) {
        return ResponseEntity.ok(dummyRequest);
    }



}
