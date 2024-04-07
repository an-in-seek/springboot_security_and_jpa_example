package com.example.securityandjpa.member.mapper;

import com.example.securityandjpa.member.domain.Member;
import com.example.securityandjpa.member.dto.MemberRequest;
import com.example.securityandjpa.member.dto.MemberResponse;

public class MemberMapper {

    public static Member toEntity(MemberRequest memberRequest) {
        return Member.builder()
            .username(memberRequest.username())
            .password(memberRequest.password())
            .nickname(memberRequest.nickname())
            .role(memberRequest.role())
            .isEnabled(true)
            .build();
    }

    public static MemberResponse toResponse(Member member) {
        return MemberResponse.builder()
            .username(member.getUsername())
            .nickname(member.getNickname())
            .role(member.getRole())
            .isEnabled(member.isEnabled())
            .createdAt(member.getCreatedAt())
            .modifiedAt(member.getModifiedAt())
            .build();
    }
}