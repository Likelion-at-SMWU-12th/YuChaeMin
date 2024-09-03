package org.zerock.yuchaemin.mapper.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.yuchaemin.mapper.entity.PostEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceMapping {

    private final PostMapper postMapper;
    public PostServiceMapping (@Autowired PostMapper postMapper) {

        this.postMapper = postMapper;
    }
    public void createPost(PostDto dto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setWriter(dto.getWriter());
        postEntity.setBoardEntity(null);

        this.postMapper.createPost(postEntity);
    }

    public PostDto getPost(int id) {
        PostEntity postEntity = this.postMapper.getPostById(id);
        return new PostDto(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() != null ? postEntity.getBoardEntity().getId() : 0
        );
    }
    public List<PostDto> getAllPosts() {
        List<PostEntity> postEntities = this.postMapper.getAllPosts();
        return postEntities.stream()
                .map(postEntity -> new PostDto(
                        postEntity.getId(),
                        postEntity.getTitle(),
                        postEntity.getContent(),
                        postEntity.getWriter(),
                        postEntity.getBoardEntity() != null ? postEntity.getBoardEntity().getId() : 0
                ))
                .collect(Collectors.toList());
    }

    public void updatePost(PostDto dto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(dto.getId());
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setWriter(dto.getWriter());
        postEntity.setBoardEntity(null);

        this.postMapper.updatePost(postEntity);
    }

    public void deletePost(int id) {
        this.postMapper.deletePost(id);
    }

}
