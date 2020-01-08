package com.example.loginsecurity.dto;

import com.example.loginsecurity.domain.entity.BoardEntity;
import com.example.loginsecurity.domain.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public BoardEntity toEntity(){
        BoardEntity build = BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
