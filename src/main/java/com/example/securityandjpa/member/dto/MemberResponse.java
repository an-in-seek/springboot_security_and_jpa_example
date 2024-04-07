package com.example.securityandjpa.member.dto;

import com.example.securityandjpa.member.domain.Role;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record MemberResponse(
    String username,
    String nickname,
    Role role,
    boolean isEnabled,
    LocalDateTime createdAt,
    LocalDateTime modifiedAt
) {

}