package org.zerock.yuchaemin.crud.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    @DeleteMapping(value = "{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    // http://localhost:8080/api/v1/delete-api/request1?key1=value1&key2=value2
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email) {
        return "e-mail : " + email;
    }
}
