package com.example.securityandjpa.mapper;

import com.example.securityandjpa.domain.Member;
import com.example.securityandjpa.request.MemberRequest;

public class MemberMapper {

    public static Member toEntity(MemberRequest memberRequest) {
        return Member.builder()
            .username(memberRequest.username())
            .password(memberRequest.password())
            .nickname(memberRequest.nickname())
            .roles(memberRequest.role())
            .isEnabled(true)
            .build();
    }
}