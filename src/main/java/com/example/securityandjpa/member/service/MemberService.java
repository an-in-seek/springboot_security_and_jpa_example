package com.example.securityandjpa.member.service;

import com.example.securityandjpa.member.domain.Member;
import com.example.securityandjpa.member.dto.MemberRequest;
import com.example.securityandjpa.member.dto.MemberResponse;
import com.example.securityandjpa.member.mapper.MemberMapper;
import com.example.securityandjpa.member.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member createMember(MemberRequest memberRequest) {
        Member member = MemberMapper.toEntity(memberRequest);
        return memberRepository.save(member);
    }

    @Transactional
    public Member updateMember(String username, MemberRequest memberRequest) {
        Member member = getMember(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        member.update(MemberMapper.toEntity(memberRequest));
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("Not Found Member."));
    }

    @Transactional(readOnly = true)
    public Optional<Member> getMember(String username) {
        return memberRepository.findById(username);
    }

    @Transactional(readOnly = true)
    public Optional<MemberResponse> getMemberResponse(String username) {
        return memberRepository.findById(username).map(MemberMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public List<MemberResponse> getMemberResponseList() {
        return memberRepository.findAll().stream().map(MemberMapper::toResponse).collect(Collectors.toList());
    }


}