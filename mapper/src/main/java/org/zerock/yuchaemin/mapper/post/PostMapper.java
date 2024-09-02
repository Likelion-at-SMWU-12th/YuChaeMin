package org.zerock.yuchaemin.mapper.post;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.yuchaemin.mapper.entity.PostEntity;

@Mapper
public interface PostMapper {
    void createPost(PostEntity postEntity);
}
