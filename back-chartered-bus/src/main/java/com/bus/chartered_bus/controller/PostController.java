package com.bus.chartered_bus.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PostController {

    @GetMapping("/post")
    public void getPost(@RequestParam String title, @RequestParam String content){
        System.out.println("게시글 제목: " + title);
        System.out.println("게시글 내용: " + content);
    }

    @GetMapping("/postjson")
    public Map<String, String> getPostJson(@RequestParam String title, @RequestParam String content){
        System.out.println("게시글 제목(json): " + title);
        System.out.println("게시글 내용(json): " + content);

        Map<String, String> response = new HashMap<>();
        response.put("게시글 제목: ", title);
        response.put("게시글 내용: ", content);

        return response;
    }

    @PostMapping("/postform")
    public String postForm(@RequestParam String title, @RequestParam String content){
        System.out.println("게시글 제목(form): " + title);
        System.out.println("게시글 내용(form): " + content);

        return "게시글 제목: " + title + ", 게시글 내용: " + content;
    }

    @PostMapping("/post1")
    public String post1(@RequestBody Map<String, String> payload) {
        String title = payload.get("title");
        String content = payload.get("content");

        System.out.println("게시글 제목(post): " + title);
        System.out.println("게시글 내용(post): " + content);

        return "게시글 제목: " + title + ", 게시글 내용: " + content;
    }
}
