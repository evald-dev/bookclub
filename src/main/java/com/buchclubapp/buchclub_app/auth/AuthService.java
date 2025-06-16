package com.buchclubapp.buchclub_app.auth;

import com.buchclubapp.buchclub_app.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthResponseDto authenticate(
            final AuthRequestDto request) {

        final var authToken = UsernamePasswordAuthenticationToken
                .unauthenticated(request.username(), request.password());

        final var authentication = authenticationManager
                .authenticate(authToken);

        final var token = jwtService.generateToken(request.username());
        return new AuthResponseDto(token);
    }
}