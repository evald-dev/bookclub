package com.buchclubapp.buchclub_app.user;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.GONE;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Member findmemberById(Long id){
        return memberRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Member not found with id"+id));
    }

    public Member addmember(Member member){
        return  memberRepository.save(member);
    }

    public Member editmember(Member newmember, Long id){
        Member editedmember = memberRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Member not found with id"+id));

        return memberRepository.findById(id)
                .map(member -> {
                    member.setUsername(newmember.getUsername());
                    member.setPassword(newmember.getPassword());
                    member.setClub(newmember.getClub());
                    member.setEmail(member.getEmail());
                    return memberRepository.save(member);
                })
                .orElseGet(() -> {
                    return memberRepository.save(newmember);
                });
    }

    public void deletemember(Long
                                   id){
        memberRepository.deleteById(id);
    }

    public Member findMemberByUsername(final String membername) {

        return memberRepository.findByUsername(membername)
                .orElseThrow(() -> new ResponseStatusException(GONE,
                        "The member account has been deleted or inactivated"));
    }
}
