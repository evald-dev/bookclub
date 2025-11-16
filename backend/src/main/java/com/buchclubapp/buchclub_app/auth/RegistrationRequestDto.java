package com.buchclubapp.buchclub_app.auth;

public record RegistrationRequestDto(String username,
                                     String email,
                                     String password,
                                     String theme) {

}
