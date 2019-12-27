package com.example.loginsecurity.domain.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


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






    @Builder
    public BoardEntity(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;

    }
}
