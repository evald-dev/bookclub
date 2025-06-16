package com.buchclubapp.buchclub_app.user;

import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberProfileDto toMemberProfileDto(final Member member) {
        return new MemberProfileDto(member.getEmail(), member.getUsername());
    }
}
