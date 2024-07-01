package com.bus.chartered_bus.model;

public class PostVO {
    private String title;
    private String content;

    // 기본 생성자
    //public PostVO(){
    //    this("기본생성자", "나는 기본생성자");
    //}

    // 생성자
//    public PostVO(String title, String content){
//        this.title=title;
//        this.content=content;
//    }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
