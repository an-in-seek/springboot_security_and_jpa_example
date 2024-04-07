package com.example.securityandjpa.post.mapper;

import com.example.securityandjpa.member.mapper.MemberMapper;
import com.example.securityandjpa.post.domain.Comment;
import com.example.securityandjpa.post.dto.CommentResponse;

public class CommentMapper {

    public static CommentResponse toResponse(Comment comment) {
        return CommentResponse.builder()
            .id(comment.getId())
            .content(comment.getContent())
            .createdBy(MemberMapper.toResponse(comment.getCreatedBy()))
            .createdAt(comment.getCreatedAt())
            .modifiedAt(comment.getModifiedAt())
            .build();
    }
}