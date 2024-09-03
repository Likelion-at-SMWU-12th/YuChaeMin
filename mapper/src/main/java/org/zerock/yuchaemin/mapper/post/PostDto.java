package org.zerock.yuchaemin.mapper.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String writer;
    private long boardId;

    public PostDto(int id, String title, String content, String writer, long board){
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
    }
}
