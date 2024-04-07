package com.example.jpaexample.request;

import com.example.jpaexample.domain.Role;
import lombok.Builder;

@Builder
public record MemberRequest(
    String username,
    String nickname,
    String password,
    Role role
) {

}