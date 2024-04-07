package com.example.jpaexample.service;

import com.example.jpaexample.domain.Comment;
import com.example.jpaexample.domain.Post;
import com.example.jpaexample.repository.CommentRepository;
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