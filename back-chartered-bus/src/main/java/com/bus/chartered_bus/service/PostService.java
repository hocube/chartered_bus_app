package com.bus.chartered_bus.service;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    public void validatePost(String writer) throws Exception{
        if(writer == null || writer.trim().isEmpty()) {
            throw new Exception("작성자는 공백일 수 없습니다.");
        }
        if(writer.length()>10){
            throw new Exception("작성자가 너무 뚱뚱합니다. 10자리 이하로 작성해주세요.");
        }
    }
}
