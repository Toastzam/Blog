package com.example.blog.repository;

import com.example.blog.entity.Article;
import com.example.blog.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {
    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */
        {
            //입력 데이터 준비
            Long articleId = 4L;
            //실제 수행과정
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상
            Article article = new Article(4L, "Hello4", "hi4");
            Comment a = new Comment(1L, article, "Park1", "hey1");
            Comment b = new Comment(2L, article, "Park2", "hey2");
            Comment c = new Comment(3L, article, "Park3", "hey3");
            List <Comment> expected = Arrays.asList(a, b, c);
            //검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글 출력");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: "Park7" 모든 댓글 조회 */
        {
            //입력 데이터 준비
            String nickname = "Park2";
            //실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);
            // 에상하기
            Comment a = new Comment(2L, new Article(4L, "Hello4", "hi4"),"Park2", "hey2");
            Comment b = new Comment(5L, new Article(5L, "Hello5", "hi5"), "Park2", "hey5");
            Comment c = new Comment(8L, new Article(6L, "Hello6", "hi6"), "Park2", "hey8");
            List <Comment> expected = Arrays.asList(a, b, c);
            // 검증
            assertEquals(expected.toString(), comments.toString(),"Park2의 모든댓글 출력");
        }
    }
}