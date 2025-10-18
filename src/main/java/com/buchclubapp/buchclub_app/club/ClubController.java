package com.buchclubapp.buchclub_app.club;

import com.buchclubapp.buchclub_app.user.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClubController {
    @Autowired
    ClubService clubService;

    @GetMapping("club/{id}")
    public Club findClubById(@PathVariable String id){
        return clubService.findClubById(id);
    }

    @PostMapping("/club")
    public Club addClub(@RequestBody Club club){
        return clubService.addClub(club);
    }

    @PutMapping("/club/{id}")
    public Club editClub(@RequestBody ClubDto clubDto, @PathVariable String id){
        return clubService.editClub(clubDto, id);
    }

    @PutMapping("/club/{id}/{memberId}")
    public Member assignMemberToClub(@PathVariable String id, @PathVariable String memberId){
        return clubService.assignMemberToClub(id,memberId);
    }
    @DeleteMapping("/club/{id}")
    public void deleteClub(@PathVariable String id){
        clubService.deleteClub(id);
    }

}
