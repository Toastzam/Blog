package com.example.blog.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestAPI 컨트롤러
public class FirstApiController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello";
    }
}
