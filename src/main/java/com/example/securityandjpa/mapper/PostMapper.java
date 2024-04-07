package com.example.securityandjpa.mapper;

import com.example.securityandjpa.domain.Post;
import com.example.securityandjpa.response.PostResponse;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostResponse toResponse(Post post) {
        return PostResponse.builder()
            .id(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .commentList(post.getCommentList().stream().map(CommentMapper::toResponse).collect(Collectors.toList()))
            .createdBy(post.getCreatedBy().toDto())
            .createdAt(post.getCreatedAt())
            .modifiedAt(post.getModifiedAt())
            .build();
    }
}