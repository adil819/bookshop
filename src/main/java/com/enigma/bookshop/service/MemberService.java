package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Member;

import java.util.List;

public interface MemberService {
    public Member addMember(Member member);
    public Member getMemberById(String uuid);
    public List<Member> getMembers();
    public Member updateMember(String uuid, Member member);
    public void hardDeleteMember(String uuid);
}
