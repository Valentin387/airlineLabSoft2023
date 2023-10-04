package com.laboratory.airlinebackend.controller;

import com.laboratory.airlinebackend.controller.DTO.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
