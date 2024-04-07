package com.example.securityandjpa.request;

import com.example.securityandjpa.domain.Role;
import lombok.Builder;

@Builder
public record MemberRequest(
    String username,
    String nickname,
    String password,
    Role role
) {

}