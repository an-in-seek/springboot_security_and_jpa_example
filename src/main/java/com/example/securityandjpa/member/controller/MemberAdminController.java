package com.example.securityandjpa.member.controller;

import com.example.securityandjpa.member.dto.MemberResponse;
import com.example.securityandjpa.member.service.MemberService;
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
@RequestMapping("/api/v1/admin/members")
public class MemberAdminController {

    private final MemberService memberService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/{username}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable String username) {
        MemberResponse memberResponse = memberService.getMemberResponse(username).orElse(null);
        return ResponseEntity.ok(memberResponse);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<MemberResponse>> getMemberList() {
        List<MemberResponse> memberResponseList = memberService.getMemberResponseList();
        return ResponseEntity.ok(memberResponseList);
    }
}