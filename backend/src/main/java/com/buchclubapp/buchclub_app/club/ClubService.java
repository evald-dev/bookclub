package com.buchclubapp.buchclub_app.club;
import com.buchclubapp.buchclub_app.user.Member;
import com.buchclubapp.buchclub_app.user.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MemberRepository memberRepository;

    public List<Member> findAllClubMembers(String clubId){
        return  memberRepository.findByClub(clubId);
    }

    public Club convertToEntity(ClubDto clubDto) {
        return modelMapper.map(clubDto, Club.class);
    }

    public Club findClubById(String id) {
        return clubRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Club not found with id:" + id));
    }

    public Club addClub(Club club,String username) {

        Club newClub = clubRepository.save(club);
        assignMemberToClub(newClub.getId(), username);
        return newClub;
    }

    public Member assignMemberToClub(String clubId, String username) {

        // 1. Lade den Club, dem der Member beitreten soll
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new NoSuchElementException("Club not found with id " + clubId));

        // 2. Lade den Member, der hinzugefügt werden soll
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("Member not found with id " + username));

        // 3. Setze die Referenz auf der "Many"-Seite (also im Member)
        member.setClub(club);

        // 4. Speichere das geänderte Dokument (den Member!)
        return memberRepository.save(member);

        // Das 'club'-Objekt wird NICHT gespeichert, da es sich nicht geändert hat.
    }

    public Club editClub(ClubDto newClubDto, String id) {


        return clubRepository.findById(id)
                .map(club -> {
                    club.setName(newClubDto.getName());
                    return clubRepository.save(club);
                })
                .orElseGet(() -> {
                    return clubRepository.save(convertToEntity(newClubDto));
                });
    }


    public void deleteClub(String id) {
        clubRepository.deleteById(id);
    }
}
