package com.example.securityandjpa.post.mapper;

import com.example.securityandjpa.member.mapper.MemberMapper;
import com.example.securityandjpa.post.domain.Post;
import com.example.securityandjpa.post.dto.PostResponse;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostResponse toResponse(Post post) {
        return PostResponse.builder()
            .id(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .commentList(post.getCommentList().stream().map(CommentMapper::toResponse).collect(Collectors.toList()))
            .createdBy(MemberMapper.toResponse(post.getCreatedBy()))
            .createdAt(post.getCreatedAt())
            .modifiedAt(post.getModifiedAt())
            .build();
    }
}