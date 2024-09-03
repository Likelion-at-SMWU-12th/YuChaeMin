package org.zerock.yuchaemin.mapper.post;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.yuchaemin.mapper.entity.PostEntity;

import java.util.List;

@Mapper
public interface PostMapper {
    void createPost(PostEntity postEntity);
    PostEntity getPostById(int id);
    List<PostEntity> getAllPosts();
    void updatePost(PostEntity postEntity);
    void deletePost(int id);
}
