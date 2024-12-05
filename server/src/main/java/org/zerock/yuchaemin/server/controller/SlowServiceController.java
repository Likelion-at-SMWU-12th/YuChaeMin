package org.zerock.yuchaemin.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.yuchaemin.server.dto.Tweet;

import java.util.Arrays;
import java.util.List;

@RestController
public class SlowServiceController {

    @GetMapping("api/v1/slow")
    public ResponseEntity<List<Tweet>> slowRsponse() {
        List<Tweet> tweets = Arrays.asList(
                new Tweet("1", "Hello World", "Author1"),
                new Tweet("2", "Spring WebFlux", "Author2")
        );

        return ResponseEntity.ok(tweets);
    }
}
