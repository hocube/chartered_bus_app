package com.bus.chartered_bus.controller;

import com.bus.chartered_bus.DTO.PostRequest;
import com.bus.chartered_bus.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private PostService postService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/post1")
    public ResponseEntity<Map<String, String>> post1(@RequestBody Map<String, String> payload) {
        String title = payload.get("title");
        String content = payload.get("content");
        String writer = payload.get("writer");

        try {
            postService.validatePost(writer);
        }catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }

        Map<String, String> response = new HashMap<>();
        response.put("제목", title);
        response.put("내용", content);
        response.put("작성자", writer);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/post2")
    public ResponseEntity<Map<String, String>> post2(@Valid @RequestBody PostRequest postRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorResponse = new HashMap<>();
            bindingResult.getAllErrors().forEach(error -> {
                errorResponse.put("error", error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errorResponse);
        }

        Map<String, String> response = new HashMap<>();
        response.put("제목", postRequest.getTitle());
        response.put("내용", postRequest.getContent());
        response.put("작성자", postRequest.getWriter());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/post3")
    public void post3(@RequestBody PostRequest postRequest) {
        System.out.println("제목 : " + postRequest.getTitle());
        System.out.println("내용 : " + postRequest.getContent());
        System.out.println("작성자 : " + postRequest.getWriter());
    }
}
