package org.zerock.yuchaemin.myspringblog1.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.yuchaemin.myspringblog1.entity.Author;
import org.zerock.yuchaemin.myspringblog1.entity.Board;
import org.zerock.yuchaemin.myspringblog1.entity.BoardMembership;
import org.zerock.yuchaemin.myspringblog1.entity.Post;
import static org.junit.jupiter.api.Assertions.*;

import java.util.PropertyPermission;

@SpringBootTest
@Transactional
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardMembershipRepository boardMembershipRepository;

    @Test
    public void saveAndReadPostTestWithBoardMembershipTest() {
        // Author 생성
        Author author = new Author();
        author.setName("Chaemin Yu");
        authorRepository.save(author);

        // Board 생성
        Board board = new Board();
        board.setName("개발");
        boardRepository.save(board);

        // BoardMembership 생성
        BoardMembership membership = new BoardMembership();
        membership.setAuthor(author);
        membership.setBoard(board);
        membership.setPermissionType(BoardMembership.PermissionType.WRITE);
        boardMembershipRepository.save(membership);

        // Post 생성
        Post post = new Post();
        post.setTitle("스프링 연관 매핑");
        post.setContent("스프링 연관 매핑 연습 중인데 이게 맞는지 모르겠어요 조금 어렵네요");
        post.setAuthor(author);
        post.setBoard(board);
        postRepository.save(post);

        // 저장된 Post 조회 및 검증
        Post savedPost = postRepository.findById(post.getId()).orElse(null);
        assertNotNull(savedPost);
        assertEquals("스프링 연관 매핑", savedPost.getTitle());
        assertEquals("Chaemin Yu", savedPost.getAuthor().getName());
        assertEquals("개발", savedPost.getBoard().getName());

        // Author를 통해 Post와 BoardMembership 조회
        Author savedAuthor = authorRepository.findById(author.getId()).orElse(null);
//        assertNotNull(savedAuthor);
//        assertTrue(savedAuthor.getPosts().contains(post));
//        assertFalse(savedAuthor.getBoardMemberships().isEmpty());

        BoardMembership savedMembership = savedAuthor.getBoardMemberships().get(0);
//        assertEquals(BoardMembership.PermissionType.WRITE, savedMembership.getPermissionType());
//        assertEquals(board.getId(), savedMembership.getBoard().getId());

        // Board를 통해 Post와 BoardMembership 조회
        Board savedBoard = boardRepository.findById(board.getId()).orElse(null);
//        assertNotNull(savedBoard);
//        assertTrue(savedBoard.getPosts().contains(post));
//        assertFalse(savedBoard.getBoardMemberships().isEmpty());
//        assertEquals(author.getId(), savedBoard.getBoardMemberships().get(0).getAuthor().getId());

        System.out.println("등록된 글: " + savedPost);
        System.out.println("글 작성자: " + savedPost.getAuthor());
        System.out.println("글 게시판: " + savedPost.getBoard());
        System.out.println("글 작성자 게시판 권한: " + savedMembership);

    }
}