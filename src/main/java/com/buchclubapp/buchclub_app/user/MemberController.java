package com.buchclubapp.buchclub_app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/member/{id}")
    public Member getMemberById(@PathVariable Long id){
        return memberService.findMemberById(id);
    }

    @PostMapping("/member")
    public Member addMember(@RequestBody Member newMember){
        return memberService.addMember(newMember);
    }

    @PutMapping("/member/{id}")
    public Member editMember(@RequestBody Member editedMember,@PathVariable Long id){
        return memberService.editMember(editedMember,id);
    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }
}

