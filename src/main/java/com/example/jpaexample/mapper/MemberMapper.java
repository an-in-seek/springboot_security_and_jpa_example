package com.example.jpaexample.mapper;

import com.example.jpaexample.domain.Member;
import com.example.jpaexample.request.MemberRequest;

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