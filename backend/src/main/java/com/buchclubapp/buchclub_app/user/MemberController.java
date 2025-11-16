package com.buchclubapp.buchclub_app.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberMapper memberMapper;

    @GetMapping("/member/{id}")
    public Member getMemberById(@PathVariable String id){
        return memberService.findmemberById(id);
    }

    @PostMapping("/member")
    public Member addMember(@RequestBody Member newmember){
        return memberService.addmember(newmember);
    }

    @PutMapping("/member/{id}")
    public Member editmember(@RequestBody Member editedmember, @PathVariable String id){
        return memberService.editmember(editedmember,id);
    }

    @DeleteMapping("/member/id/{id}")
    public void deletemember(@PathVariable String id){
        memberService.deletemember(id);
    }

    @GetMapping("/member/me")
    public ResponseEntity<MemberProfileDto> getMemberProfile(final Authentication authentication){
        final var member = memberService.findMemberByUsername(authentication.getName());

        return ResponseEntity.ok(memberMapper.toMemberProfileDto(member));
    }

    @GetMapping("/member/username/{username}")
    public Member getmemberByMembername(@PathVariable String username){
        return memberService.findMemberByUsername(username);
    }

    @PostMapping("/member/theme/{theme}")
    public Member setMemberTheme(@RequestBody String memberId,String theme){
        return memberService.setTheme(memberId,theme);
    }
}

