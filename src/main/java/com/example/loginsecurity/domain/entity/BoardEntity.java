package com.example.loginsecurity.domain.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
public class BoardEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long memberId;

    @Builder
    public BoardEntity(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifiedDate, Long memberId) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.memberId = memberId;
    }
}
