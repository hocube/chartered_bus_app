package com.bus.chartered_bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class HelloController {

    @GetMapping("hello1")
    public String hello1(Model model) {
        model.addAttribute("data", "헬로우지호");
        return "hello";
    }

    @GetMapping("hello2")
    public String hello2(){
        return "헬로우지호2";
    }

    @GetMapping("hello3")
    @ResponseBody
    public String hello3(){
        return "헬로우지호3";
    }

    @GetMapping("hello4")
    public Map<String, String> hello4(){
        Map<String, String> data = new HashMap<>();
        data.put("message", "헬로우지호 이건 json");
        return data;
    }

    @GetMapping("hello")
    public String hello(){
        return "안녕하세요. 현재 서버시간은 "+new Date() + "입니다. \n";
    }
}
