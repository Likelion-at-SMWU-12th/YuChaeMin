package org.zerock.yuchaemin.mapper.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Post")
public class PostControllerMapper {
    private static final Logger logger = LoggerFactory.getLogger(PostControllerMapper.class);
    private final PostServiceMapping postServiceMapping;

    public PostControllerMapper(@Autowired PostServiceMapping postService) {
        this.postServiceMapping = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto) {
        this.postServiceMapping.createPost(postDto);
    }
}
