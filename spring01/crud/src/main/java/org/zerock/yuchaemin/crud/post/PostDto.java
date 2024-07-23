package org.zerock.yuchaemin.crud.post;
public class PostDto {
    private String title;
    private String content;
    private String writer;

    public PostDto(String title, String content, String writer){
        this.title=title;
        this.content=content;
        this.writer=writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return "PostDto{"+
                "title="+title+'\''+
                ",content="+content+'\''+
                "}";
    }
}
