package com.example.securityandjpa.post.dto;

import com.example.securityandjpa.member.dto.MemberResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
@JsonInclude(Include.NON_NULL)
public record CommentResponse(
    long id,
    String content,
    MemberResponse createdBy,
    LocalDateTime createdAt,
    LocalDateTime modifiedAt
) {

}