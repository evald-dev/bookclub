package com.buchclubapp.buchclub_app.auth;

import lombok.AllArgsConstructor;

public record RegistrationResponseDto(String username,
                                      String email,
                                      String theme) {
}
