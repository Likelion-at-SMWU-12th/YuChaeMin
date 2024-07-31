package org.zerock.yuchaemin.crud.Controller;

import org.apache.catalina.loader.ResourceEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.yuchaemin.crud.Dto.MemberDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    // http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMember3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
