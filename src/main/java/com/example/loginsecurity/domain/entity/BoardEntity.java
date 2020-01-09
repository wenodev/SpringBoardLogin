package com.example.loginsecurity.domain.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table
@ToString(exclude = {"memberEntity"})
public class BoardEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;



    // Order N : 1 User
    @ManyToOne
    private MemberEntity memberEntity;

    @Builder
    public BoardEntity(Long id, String title, String content, String writer, LocalDateTime createDate, LocalDateTime modifiedDate, MemberEntity memberEntity) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.memberEntity = memberEntity;

    }
}
