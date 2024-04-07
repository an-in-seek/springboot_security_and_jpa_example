package com.example.securityandjpa.member.dto;

import com.example.securityandjpa.member.domain.Role;
import lombok.Builder;

@Builder
public record MemberRequest(
    String username,
    String nickname,
    String password,
    Role role
) {

}