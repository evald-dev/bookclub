package com.buchclubapp.buchclub_app.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClubController {
    @Autowired
    ClubService clubService;

    @GetMapping("club/{id}")
    public Club findClubById(@PathVariable Long id){
        return clubService.findClubById(id);
    }

    @PostMapping("/club")
    public Club addClub(@RequestBody Club club){
        return clubService.addClub(club);
    }

    @PutMapping("/club/{id}")
    public Club editClub(@RequestBody ClubDto clubDto, @PathVariable Long id){
        return clubService.editClub(clubDto, id);
    }

    @DeleteMapping("/club/{id}")
    public void deleteClub(@PathVariable Long id){
        clubService.deleteClub(id);
    }

}
