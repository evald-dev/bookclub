package com.buchclubapp.buchclub_app.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    private final RegistrationMapper registrationMapper;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponseDto> registerMember(@RequestBody RegistrationRequestDto registrationDto) {

        final var registeredMember = registrationService.registerMember(registrationDto);

        return ResponseEntity.ok(registrationMapper.registrationResponseDto(registeredMember));
    }

}
