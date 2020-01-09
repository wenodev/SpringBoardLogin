package com.example.loginsecurity.domain.repository;

import com.example.loginsecurity.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByEmail(String userEmail);
    Optional<MemberEntity> findById(Long userId);
}
