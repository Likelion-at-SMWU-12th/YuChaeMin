package org.zerock.yuchaemin.crud.Controller;

import org.springframework.web.bind.annotation.*;
import org.zerock.yuchaemin.crud.Dto.MemberDto;

import javax.xml.crypto.Data;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    // http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " +map.getValue() + "\n");
        });
        return sb.toString();
    };

    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/memeber2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
