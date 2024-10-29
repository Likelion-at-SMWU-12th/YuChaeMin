package org.zerock.yuchaemin.spring08.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping
    public String mainP() {
        return "Main Controller : ";
    }
}
