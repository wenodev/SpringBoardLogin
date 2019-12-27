package com.example.loginsecurity.dto;

import com.example.loginsecurity.domain.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .createDate(createdDate)
                .modifiedDate(modifiedDate)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, LocalDateTime createdDate,  LocalDateTime modifiedDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}