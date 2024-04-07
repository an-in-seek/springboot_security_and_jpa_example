package com.example.securityandjpa.post.service;

import com.example.securityandjpa.post.domain.Comment;
import com.example.securityandjpa.post.domain.Post;
import com.example.securityandjpa.post.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository postRepository;

    @Transactional
    public Comment createComment(Post post, String content) {
        Comment comment = Comment.builder()
            .post(post)
            .content(content)
            .build();
        return postRepository.save(comment);
    }
}