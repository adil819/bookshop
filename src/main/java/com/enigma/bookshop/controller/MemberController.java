package com.enigma.bookshop.controller;

import com.enigma.bookshop.entity.Member;
import com.enigma.bookshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;
    private String uuid;

    @PostMapping("/members")
    public Member createMembers(@RequestBody Member member){
        return memberService.addMember(member);
    }

    @GetMapping("/members/{id}")
    public Member getMemberById(@PathVariable String uuid){
        this.uuid = uuid;
        return memberService.getMemberById(uuid);
    }

    @GetMapping("/members")
    public List<Member> getMembers(){
        return memberService.getMembers();
    }

    @PutMapping("/members/{uuid}")
    public Member updateMember(@PathVariable String uuid, @RequestBody Member member){
        return memberService.updateMember(uuid, member);
    }

    @DeleteMapping("/members/{uuid}")
    public void hardDeleteMember(@PathVariable String uuid){
        memberService.hardDeleteMember(uuid);
    }

}
