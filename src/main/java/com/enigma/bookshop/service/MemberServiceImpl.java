package com.enigma.bookshop.service;


import com.enigma.bookshop.entity.Member;
import com.enigma.bookshop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(String uuid) {
        return memberRepository.findById(uuid).get();
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member updateMember(String uuid, Member member) {
        Member member_update = memberRepository.findById(uuid).get();
        if(member_update != null) {
            member_update = member;
            member_update.setUuid(uuid);
            return memberRepository.save(member);
        } else {
            return null;
        }

    }

    @Override
    public void hardDeleteMember(String uuid) {
        memberRepository.deleteById(uuid);
    }

}
