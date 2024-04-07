package com.example.jpaexample.service;

import com.example.jpaexample.domain.Post;
import com.example.jpaexample.mapper.PostMapper;
import com.example.jpaexample.repository.PostRepository;
import com.example.jpaexample.response.PostResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post createPost(String title, String content) {
        Post post = Post.builder()
            .title(title)
            .content(content)
            .build();
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public Optional<PostResponse> getPostResponse(long id) {
        return postRepository.findById(id).map(PostMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostResponseList() {
        return postRepository.findAll().stream().map(PostMapper::toResponse).collect(Collectors.toList());
    }
}