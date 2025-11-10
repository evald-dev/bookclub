package com.buchclubapp.buchclub_app.club;

import com.buchclubapp.buchclub_app.user.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClubController {
    @Autowired
    ClubService clubService;

    @GetMapping("club/{id}")
    public Club findClubById(@PathVariable String id){
        return clubService.findClubById(id);
    }

    @GetMapping("/club/members/{id}")
    public List<Member> findMembersByClub(@PathVariable String id){
        return  clubService.findAllClubMembers(id);
    }

    @PostMapping("/club")
    public Club addClub(@RequestBody Club club,Authentication authentication){
        return clubService.addClub(club, authentication.getName());
    }

    @PutMapping("/club/{id}")
    public Club editClub(@RequestBody ClubDto clubDto, @PathVariable String id){
        return clubService.editClub(clubDto, id);
    }

    @PutMapping("/club/{id}/{memberId}")
    public Member assignMemberToClub(@PathVariable String id, Authentication authentication){
        return clubService.assignMemberToClub(id,authentication.getName());
    }
    @DeleteMapping("/club/{id}")
    public void deleteClub(@PathVariable String id){
        clubService.deleteClub(id);
    }

}
