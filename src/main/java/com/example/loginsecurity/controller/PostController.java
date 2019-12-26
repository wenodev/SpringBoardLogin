//package com.example.loginsecurity.controller;
//
//import com.example.loginsecurity.dto.MemberDto;
//import com.example.loginsecurity.service.BoardService;
//import com.example.loginsecurity.service.MemberService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//@Controller
//@AllArgsConstructor
//public class PostController {
//    private MemberService memberService;
//    private BoardService boardService;
//
//
//    // 회원가입 처리
//    @PostMapping("/user/signup")
//    public String execSignup(MemberDto memberDto) {
//        memberService.joinUser(memberDto);
//
//        return "redirect:/user/login";
//    }
//}
