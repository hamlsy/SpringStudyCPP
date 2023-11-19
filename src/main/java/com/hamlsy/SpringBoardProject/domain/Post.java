package com.hamlsy.SpringBoardProject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity // JPA에서 entity 인식
public class Post {
    @Id // 고유 키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // GeneratedValue = 저장할 때 자동으로 1 증가
    // strategy = 고유번호 생성
    // GenerationType.IDENTITY = 해당 컬럼의 독립적 시퀸스 생성
    private Integer id; // 게시글 id

    @Column(length = 200) // 테이블의 컬럼으로 인식
    private String subject; // 게시글 제목

    @Column(columnDefinition = "TEXT") // 테이블의 컬럼으로 인식
    //글자 수를 제한할 수 없는 경우 설정
    private String content; // 내용
    private LocalDateTime createDate; // 작성 날짜
    //글을 지우면 댓글들도 같이 지워짐
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;
}
// 데이터베이스와 연동하는 JPA repository 필요 -> Posts Repository