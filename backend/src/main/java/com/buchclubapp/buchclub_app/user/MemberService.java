package com.buchclubapp.buchclub_app.user;
import com.buchclubapp.buchclub_app.club.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.GONE;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ClubRepository clubRepository;

    public Member findmemberById(String id){
        return memberRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Member not found with id"+id));
    }

    public Member addmember(Member member){
        return  memberRepository.save(member);
    }

    @Transactional
    public Member editmember(Member newmember, String id){
        Member editedmember = memberRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Member not found with id"+id));

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

    public void deletemember(String
                                   id){
        memberRepository.deleteById(id);
    }


    public Member findMemberByUsername(final String membername) {

        return memberRepository.findByUsername(membername)
                .orElseThrow(() -> new ResponseStatusException(GONE,
                        "The member account has been deleted or inactivated"));
    }

}

