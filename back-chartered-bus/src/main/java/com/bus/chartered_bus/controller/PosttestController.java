package com.bus.chartered_bus.controller;

import com.bus.chartered_bus.model.PostVO;

public class PosttestController {
    public static void main(String[] args) {
        PostVO postVO1 = new PostVO();
        System.out.println(postVO1.getTitle());
        System.out.println(postVO1.getContent());

//        PostVO postVO =  new PostVO("안녕", "나는 지호");
//        System.out.println(postVO.getTitle());
//        System.out.println(postVO.getContent());
    }
}
