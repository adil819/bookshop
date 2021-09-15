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
    public Member getMemberById(Integer id) {
        return memberRepository.findById(id).get();
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member updateMember(Integer id, Member member) {
        Member member_update = memberRepository.findById(id).get();
        if(member_update != null) {
            member_update = member;
            member_update.setId(id);
            return memberRepository.save(member);
        } else {
            return null;
        }

    }

    @Override
    public void hardDeleteMember(Integer id) {
        memberRepository.deleteById(id);
    }

}
