package com.example.securityandjpa.config;

import com.example.securityandjpa.domain.Post;
import com.example.securityandjpa.domain.Role;
import com.example.securityandjpa.request.MemberRequest;
import com.example.securityandjpa.service.CommentService;
import com.example.securityandjpa.service.MemberService;
import com.example.securityandjpa.service.PostService;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final MemberService memberService;
    private final PostService postService;
    private final CommentService commentService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        MemberRequest admin = MemberRequest.builder()
            .username("admin")
            .password(passwordEncoder.encode("admin"))
            .nickname("관리자")
            .role(Role.ADMIN)
            .build();
        memberService.createUser(admin);

        MemberRequest user = MemberRequest.builder()
            .username("user")
            .password(passwordEncoder.encode("user"))
            .nickname("사용자")
            .role(Role.USER)
            .build();
        UserDetails userDetails = memberService.createUser(user);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
            userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Post post = postService.createPost("제목" + i, "내용" + i);
            commentService.createComment(post, "댓글" + i);
        });
    }
}