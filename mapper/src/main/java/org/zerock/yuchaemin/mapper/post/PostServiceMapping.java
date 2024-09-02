package org.zerock.yuchaemin.mapper.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.yuchaemin.mapper.entity.PostEntity;

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
}
