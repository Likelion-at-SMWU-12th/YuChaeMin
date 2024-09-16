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
@Table(name = "author")
public class Author extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Post> postList = new ArrayList<>();

    public void addPost(Post post) { this.postList.add(post); }

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Comment> commentList = new ArrayList<>();
}
