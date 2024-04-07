package com.example.securityandjpa.controller;

import com.example.securityandjpa.response.PostResponse;
import com.example.securityandjpa.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable long id) {
        PostResponse postResponse = postService.getPostResponse(id).orElse(null);
        return ResponseEntity.ok(postResponse);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<PostResponse>> getPostList() {
        List<PostResponse> postResponseList = postService.getPostResponseList();
        return ResponseEntity.ok(postResponseList);
    }
}
