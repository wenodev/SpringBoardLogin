package com.example.loginsecurity.service;

import com.example.loginsecurity.domain.entity.BoardEntity;
import com.example.loginsecurity.domain.repository.BoardRepository;
import com.example.loginsecurity.domain.repository.MemberRepository;
import com.example.loginsecurity.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;



    @Transactional
    public List<BoardDto> getBoardlist() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();


        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createDate(boardEntity.getCreateDate())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }

//    @Transactional
//    public Long savePost(BoardDto boardDto){
//        return boardRepository.save(boardDto.toEntity()).getId();
//    }

    @Transactional
    public BoardDto getPost(Long id) {
        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(id);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDTO = BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .createDate(boardEntity.getCreateDate())
                .build();

        return boardDTO;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {

        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }



}
