package org.zerock.yuchaemin.crud.post;

//import com.example.crud.GsonComponent;
//import com.example.crud.aspect.LogExecutionTime;
//import com.example.crud.aspect.LogParameters;
//import com.example.crud.aspect.LogReturn;
//import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
//    private final Gson gson;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto) {
        this.postService.createPost(postDto);
    }

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        return this.postService.readPost(id);
    }

    @GetMapping("")
    public List<PostDto> readPostAll() {
        return this.postService.readPostAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDto postDto) {
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }
}
