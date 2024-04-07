package com.example.jpaexample.response;

import com.example.jpaexample.domain.Role;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record MemberResponse(
    String username,
    String nickname,
    Role role,
    LocalDateTime createdAt
) {

}