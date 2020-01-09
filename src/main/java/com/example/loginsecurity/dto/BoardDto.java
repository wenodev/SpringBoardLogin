package com.example.loginsecurity.dto;

import com.example.loginsecurity.domain.entity.BoardEntity;
import com.example.loginsecurity.domain.entity.MemberEntity;
import lombok.*;

import javax.persistence.ManyToOne;
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

    // Order N : 1 User
    @ManyToOne
    private MemberEntity memberEntity;

    public BoardEntity toEntity(){
        BoardEntity build = BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .createDate(createDate)
                .modifiedDate(modifiedDate)
                .memberEntity(memberEntity)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String content, String writer, LocalDateTime createDate, LocalDateTime modifiedDate, MemberEntity memberEntity) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.memberEntity = memberEntity;
    }


}
