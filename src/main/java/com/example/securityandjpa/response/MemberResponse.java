package com.example.securityandjpa.response;

import com.example.securityandjpa.domain.Role;
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