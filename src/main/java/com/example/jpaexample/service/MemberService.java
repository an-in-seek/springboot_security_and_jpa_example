package com.example.jpaexample.service;

import com.example.jpaexample.domain.Member;
import com.example.jpaexample.mapper.MemberMapper;
import com.example.jpaexample.repository.MemberRepository;
import com.example.jpaexample.request.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member createUser(MemberRequest memberRequest) {
        Member member = MemberMapper.toEntity(memberRequest);
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("Not Found Member."));
    }
}