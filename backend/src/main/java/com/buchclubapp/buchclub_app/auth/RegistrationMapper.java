package com.buchclubapp.buchclub_app.auth;


import com.buchclubapp.buchclub_app.user.Member;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {


    public Member toEntity(RegistrationRequestDto registrationRequestDto){
        final var member = new Member();

        member.setEmail(registrationRequestDto.email());
        member.setUsername(registrationRequestDto.username());
        member.setPassword(registrationRequestDto.password());

        return member;
    }

    public RegistrationResponseDto registrationResponseDto(final Member member){
        return new RegistrationResponseDto(
                member.getUsername(), member.getEmail(), member.getTheme());
    }
}
