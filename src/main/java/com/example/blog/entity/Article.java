package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity// 얘가 있어야 DB가 객체인식가능 해당 클래스로 테이블을 만듬
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자
@Getter
public class Article {
    @Id // 대표값지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를 자동생성 번호자동생성
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }
}
