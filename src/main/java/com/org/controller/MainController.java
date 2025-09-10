package com.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {

        return "main";
    }
    @GetMapping("/main")
    public String mmain() {

        return "main";
    }
    @GetMapping("/hh")
    public String hmain() {

        return "main";
    }
    @GetMapping("/test1")
    public String test1main() {

        return "main";
    }
    @GetMapping("/test2")
    public String test2main() {

        return "main";
    }
    @GetMapping("/test3")
    public String test3main() {

        return "main";
    }
}
