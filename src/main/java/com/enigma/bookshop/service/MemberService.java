package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Member;

import java.util.List;

public interface MemberService {
    public Member addMember(Member member);
    public Member getMemberById(Integer id);
    public List<Member> getMembers();
    public Member updateMember(Integer id, Member member);
    public void hardDeleteMember(Integer id);
}
