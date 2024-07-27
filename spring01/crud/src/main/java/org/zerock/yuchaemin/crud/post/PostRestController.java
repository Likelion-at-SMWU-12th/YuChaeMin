package org.zerock.yuchaemin.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger=
            LoggerFactory.getLogger(PostRestController.class);
    private final List<PostDto> postList;
    public PostRestController() {
        this.postList = new ArrayList<>();
    }

    // 1 createPost
    // http://localhost:8080/post
    // POST /post
    @PostMapping()
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    // 2 get
    // http://localhost:8080/post
    // GET /post
    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("in read post all");
        return this.postList;
    }

    // GET /post/0/
    // GET /post?id=0/
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("in read post");
        return this.postList.get(id);
    }

    // !!여기서부터 과제!!

    // PUT /post/0/
    // PUT /post/?id=0/
    @PutMapping("{id}")
    public void updatePost(@RequestBody PostDto postDto, @PathVariable("id") int id){
        logger.info("in update post with id: " + id);
        if (id>=0 && id<this.postList.size()){
            PostDto existingPost = this.postList.get(id);
            existingPost.setTitle(postDto.getTitle());
            existingPost.setContent(postDto.getContent());
            existingPost.setWriter(postDto.getWriter());
            logger.info("post updated: " + existingPost);
        } else {
            logger.error("post with id " + id + " not found");
        }
    }

    // DELETE /post/0/
    // DELETE /post/{id}/
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id) {
        logger.info("in delete post with id: " + id);
        if (id>=0 && id<this.postList.size()){
            PostDto removedPost = this.postList.remove(id);
            logger.info("post removed: "+ removedPost);
        } else {
            logger.error("post with id " + id + " not found");
        }
    }
}
