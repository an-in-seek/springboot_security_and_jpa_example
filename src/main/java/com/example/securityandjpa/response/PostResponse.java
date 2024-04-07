package com.example.securityandjpa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;

@Builder
@JsonInclude(Include.NON_NULL)
public record PostResponse(
    long id,
    String title,
    String content,
    List<CommentResponse> commentList,
    MemberResponse createdBy,
    LocalDateTime createdAt,
    LocalDateTime modifiedAt
) {

}