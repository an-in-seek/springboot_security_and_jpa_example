package com.example.jpaexample.mapper;

import com.example.jpaexample.domain.Comment;
import com.example.jpaexample.response.CommentResponse;

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