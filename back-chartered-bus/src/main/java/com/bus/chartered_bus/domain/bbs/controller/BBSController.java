package com.bus.chartered_bus.domain.bbs.controller;

import com.bus.chartered_bus.domain.bbs.model.BBSVO;
import com.bus.chartered_bus.domain.bbs.service.BBSService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bbs")
public class BBSController {

    private final BBSService bbsService;

    public BBSController(BBSService bbsService) {
        this.bbsService = bbsService;
    }

    // 견적문의 게시글 조회
    @GetMapping("/list")
    public List<BBSVO> SelectListAll() {
        List<BBSVO> result = bbsService.findAll();
        result.forEach(list -> System.out.println(list));
        return result;
    }

    // 견적문의 게시글 입력
    @PostMapping("/quotation")
    public ResponseEntity<String> insertQuotation(@RequestBody BBSVO bbsvo) {
        String resultMessage = bbsService.createQuotation(bbsvo);
        if ("등록 성공".equals(resultMessage)) {
            return new ResponseEntity<>(resultMessage, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(resultMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 견적문의 게시글 삭제
    @DeleteMapping("/delete/{quoteNumber}")
    public ResponseEntity<String> deleteQuotation(@PathVariable Integer quoteNumber) {
        bbsService.deleteQuotation(quoteNumber);
        return new ResponseEntity<>("삭제 성공", HttpStatus.CREATED);
    }

    // 견적문의 게시글 수정
    @PatchMapping("/update/{quoteNumber}")
    public ResponseEntity<String> updateQuotation(@PathVariable Integer quoteNumber, @RequestBody BBSVO bbsvo) {
        String resultMessage = bbsService.updateQuotation(quoteNumber, bbsvo);
        if ("수정 성공".equals(resultMessage)) {
            return new ResponseEntity<>(resultMessage, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(resultMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
