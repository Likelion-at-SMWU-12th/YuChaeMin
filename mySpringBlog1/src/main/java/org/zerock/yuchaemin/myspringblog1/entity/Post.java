package org.zerock.yuchaemin.myspringblog1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "post")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id")
    @ToString.Exclude
    private Board board;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private Author author;

    @OneToMany(mappedBy = "post")
    @ToString.Exclude
    private List<Comment> commentList = new ArrayList<>();

    public void addComment(Comment comment) {
        this.commentList.add(comment);
        comment.setPost(this);
    }

    public void removeComment(Comment comment) {
        this.commentList.remove(comment);
        comment.setPost(null);
    }

    public void setAuthor(Author author) {
        this.author = author;
        if (author != null && !author.getPosts().contains(this)) {
            author.getPosts().add(this);
        }
    }
    public void setBoard(Board board) {
        this.board = board;
        if (board != null && !board.getPosts().contains(this)) {
            board.getPosts().add(this);
        }
    }

}
