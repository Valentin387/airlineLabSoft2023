package com.laboratory.airlinebackend.controller;

import com.laboratory.airlinebackend.controller.DTO.*;
import com.laboratory.airlinebackend.controller.exceptions.EmailAlreadyTakenException;
import com.laboratory.airlinebackend.controller.service.AuthenticationService;
import com.laboratory.airlinebackend.controller.service.EmailSenderService;
import com.laboratory.airlinebackend.model.User;
import com.laboratory.airlinebackend.repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailSenderService emailSenderService;

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

        Map<String, Object> result = new HashMap<>();
        result.put("user", u);


        return ResponseEntity.ok(result);
    }

    @PostMapping("/emailChecking/{userEmail}")
    public ResponseEntity<?> emailChecking(@PathVariable String userEmail){
        String body = "Estimado/a [Nombre del Usuario],\n" +
                "\n" +
                "Espero que este mensaje le encuentre bien.\n" +
                "\n" +
                "Hemos recibido una solicitud para restablecer la contraseña de su cuenta en nuestro sistema. Para proceder con la creación de una nueva contraseña y recuperar el acceso a su cuenta, le invitamos a hacer clic en el siguiente enlace:\n" +
                "\n" +
                "http://localhost:5173/auth/recoverPassword\n" +
                "\n" +
                "Una vez que haya accedido al enlace, siga las instrucciones proporcionadas para establecer una nueva contraseña segura. Asegúrese de elegir una contraseña que sea única y que cumpla con nuestras políticas de seguridad.\n" +
                "\n" +
                "Si usted no solicitó este restablecimiento de contraseña, por favor póngase en contacto con nuestro equipo de soporte inmediatamente para investigar cualquier actividad no autorizada en su cuenta.\n" +
                "\n" +
                "Le agradecemos por confiar en nuestros servicios y estamos aquí para ayudarle en caso de cualquier duda o inquietud.\n" +
                "\n" +
                "Atentamente," +
                "\n" +
                "El equipo de AirTravelLabSoft";
        emailSenderService.sendEmail(userEmail,
                "Recuperación de cuenta en AirTravelLabSoft", body);
        return ResponseEntity.ok("the Email was sent");
    }




}