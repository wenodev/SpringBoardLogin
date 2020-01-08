package com.example.loginsecurity.domain.entity;

import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table
@ToString(exclude = {"boardEntityList"})
public class MemberEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime modifiedDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "memberEntity")
    private List<BoardEntity> boardEntityList;

    @Builder
    public MemberEntity(Long id, String email, String password, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;

    }
}
