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
    private Integer id;

    @PostMapping("/members")
    public Member createMembers(@RequestBody Member member){
        return memberService.addMember(member);
    }

    @GetMapping("/members/{id}")
    public Member getMemberById(@PathVariable Integer id){
        this.id = id;
        return memberService.getMemberById(id);
    }

    @GetMapping("/members")
    public List<Member> getMembers(){
        return memberService.getMembers();
    }

    @PutMapping("/members/{id}")
    public Member updateMember(@PathVariable Integer id, @RequestBody Member member){
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/members/{id}")
    public void hardDeleteMember(@PathVariable Integer id){
        memberService.hardDeleteMember(id);
    }

}
