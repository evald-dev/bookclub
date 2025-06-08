package com.buchclubapp.buchclub_app.user;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Member findMemberById(Long id){
        return memberRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Member not found with id"+id));
    }

    public Member addMember(Member member){
        return  memberRepository.save(member);
    }

    public Member editMember(Member newMember,Long id){
        Member editedMember = memberRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Member not found with id"+id));

        return memberRepository.findById(id)
                .map(member -> {
                    member.setUsername(newMember.getUsername());
                    member.setPassword(newMember.getPassword());
                    member.setClub(newMember.getClub());
                    member.setRole(newMember.getRole());
                    member.setEmail(member.getEmail());
                    return memberRepository.save(member);
                })
                .orElseGet(() -> {
                    return memberRepository.save(newMember);
                });
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }
}
