package com.example.jpaexample.mapper;

import com.example.jpaexample.domain.Post;
import com.example.jpaexample.response.PostResponse;
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