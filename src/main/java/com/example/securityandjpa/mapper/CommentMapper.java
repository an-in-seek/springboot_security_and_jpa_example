package com.example.securityandjpa.mapper;

import com.example.securityandjpa.domain.Comment;
import com.example.securityandjpa.response.CommentResponse;

public class CommentMapper {

    public static CommentResponse toResponse(Comment comment) {
        return CommentResponse.builder()
            .id(comment.getId())
            .content(comment.getContent())
            .createdBy(comment.getCreatedBy().toDto())
            .createdAt(comment.getCreatedAt())
            .modifiedAt(comment.getModifiedAt())
            .build();
    }
}