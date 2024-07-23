package org.zerock.yuchaemin.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping ("post") // 요청 url을 어떤 메소드가 처리할 지 매핑해줌. Controller나 Controller의 메소드에 적용. 요청받는 형식을 지정하지 않으면 GET이 디폴트
public class PostController {
//    화면 상 or 파일 로그를 남길 목적으로 사용되는 모듈
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final List<PostDto> postList;

    public PostController(){
        postList=new ArrayList<>();
    }

    // CRUD- CREATE 실습
    // @RequestMapping(Method=RequestMethod.POST)와 같음
    @PostMapping("create")
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    // CRUD- READ 실습
    @GetMapping("read-all")
    public List<PostDto> readPostAll(){
        logger.info("in read all");
        return this.postList;
    }
    @GetMapping("read-one")
    public PostDto readPostOne(@RequestParam("id") int id){
        logger.info("in read one");
        return this.postList.get(id);
    }

    // CRUD- UPDATE 실습
    @PostMapping("update")
    public void updatePost(
            @RequestParam("id") int id,
            @RequestBody PostDto postDto
    ){
        PostDto targetPost = this.postList.get(id);
        if(postDto.getTitle()!=null){
            targetPost.setTitle(postDto.getTitle());
        }
        if(postDto.getContent()!=null){
            targetPost.setContent(postDto.getContent());
        }
        this.postList.set(id, targetPost);
    }

    // CRUD- DELETE 실습
    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id){
        this.postList.remove(id);
    }
}
