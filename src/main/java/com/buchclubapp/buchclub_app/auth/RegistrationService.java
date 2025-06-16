package com.buchclubapp.buchclub_app.auth;

import com.buchclubapp.buchclub_app.book.BookDto;
import com.buchclubapp.buchclub_app.user.Member;
import com.buchclubapp.buchclub_app.user.MemberRepository;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member registerMember(RegistrationRequestDto request) {
        if (memberRepository.existsByUsername(request.username())) {
            throw new ValidationException("membername already exists");
        }
        if (memberRepository.existsByEmail(request.email())) {
            throw new ValidationException("Email already exists");
        }

        Member member = new Member();
        member.setUsername(request.username());
        member.setEmail(request.email());
        member.setPassword(passwordEncoder.encode(request.password()));

        return memberRepository.save(member);
    }
}
