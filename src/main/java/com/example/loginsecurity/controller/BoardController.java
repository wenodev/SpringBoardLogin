package com.example.loginsecurity.controller;

import com.example.loginsecurity.domain.entity.MemberEntity;
import com.example.loginsecurity.dto.BoardDto;
import com.example.loginsecurity.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    //    @GetMapping("/")
    //    public String list(){
    //        return "/board/list.html";
    //    }


    /* 게시글 목록 */
    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);


        return "/board/list.html";
    }


    @GetMapping("/post")
    public String write(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("name : " + auth.getName() );
        System.out.println("class : " + auth.getClass() );
        System.out.println("tostring : " + auth.toString() );
        System.out.println("getDetails : " + auth.getDetails() );

        return "/board/write.html";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "/board/detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "/board/update.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){


        
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @PostMapping("/post/edit/{no}")
    public String update(BoardDto boardDTO) {
        boardService.savePost(boardDTO);

        return "redirect:/";
    }

    @PostMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }

}
