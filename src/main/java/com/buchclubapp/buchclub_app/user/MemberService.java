package com.buchclubapp.buchclub_app.user;

import com.buchclubapp.buchclub_app.club.Club;
import com.buchclubapp.buchclub_app.club.ClubRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.http.HttpStatus.GONE;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ClubRepository clubRepository;

    public Member findmemberById(Long id){
        return memberRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Member not found with id"+id));
    }

    public Member addmember(Member member){
        return  memberRepository.save(member);
    }

    @Transactional
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

    @Transactional // Wichtig: Für Schreiboperationen wird eine Transaktion benötigt
    public Member assignClubToMember(Long memberId, Long clubId) {
        // 1. Member finden
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with id " + memberId));

        // 2. Club finden
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new EntityNotFoundException("Club not found with id " + clubId));

        // 3. Bidirektionale Verknüpfung korrekt setzen
        // Erst das alte Club vom Member trennen, falls vorhanden


        // Dann das Member dem neuen Club zuweisen (was auch den Club beim Member setzt)
        club.addMember(member);


        return member;
    }

    public Member findMemberByUsername(final String membername) {

        return memberRepository.findByUsername(membername)
                .orElseThrow(() -> new ResponseStatusException(GONE,
                        "The member account has been deleted or inactivated"));
    }
}
