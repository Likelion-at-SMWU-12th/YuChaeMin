package org.zerock.yuchaemin.crud.Controller;

import org.springframework.web.bind.annotation.*;
import org.zerock.yuchaemin.crud.Dto.MemberDto;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String getHello() {
//        return "Hello World";
//    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }

    // http://localhost:8080/api/v`/get-api/variable1/{String 값}
    @GetMapping(value = "/variable/{variable}")
    public String getVariable(@PathVariable String variable){
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2&key3=value3
    @GetMapping(value= "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }

}
