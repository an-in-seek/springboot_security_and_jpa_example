package com.example.securityandjpa.member.controller;

import com.example.securityandjpa.member.domain.Member;
import com.example.securityandjpa.member.dto.MemberRequest;
import com.example.securityandjpa.member.dto.MemberResponse;
import com.example.securityandjpa.member.mapper.MemberMapper;
import com.example.securityandjpa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @Secured("ROLE_USER")
    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@RequestBody MemberRequest memberRequest) {
        Member member = memberService.createMember(memberRequest);
        MemberResponse memberResponse = MemberMapper.toResponse(member);
        return ResponseEntity.ok(memberResponse);
    }

    @Secured("ROLE_USER")
    @PutMapping("/{username}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable String username, @RequestBody MemberRequest memberRequest) {
        Member member = memberService.updateMember(username, memberRequest);
        MemberResponse memberResponse = MemberMapper.toResponse(member);
        return ResponseEntity.ok(memberResponse);
    }

    @Secured("ROLE_USER")
    @GetMapping("/{username}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable String username) {
        MemberResponse memberResponse = memberService.getMemberResponse(username)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(memberResponse);
    }
}