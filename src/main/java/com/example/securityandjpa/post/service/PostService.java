package com.example.securityandjpa.post.service;

import com.example.securityandjpa.post.domain.Post;
import com.example.securityandjpa.post.dto.PostResponse;
import com.example.securityandjpa.post.mapper.PostMapper;
import com.example.securityandjpa.post.repository.PostRepository;
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