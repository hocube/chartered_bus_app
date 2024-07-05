package com.bus.chartered_bus.domain.bbs.service;

import com.bus.chartered_bus.domain.bbs.model.BBSVO;
import com.bus.chartered_bus.domain.bbs.repository.BBSRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BBSService {

    private final BBSRepository bbsRepository;

    public BBSService(BBSRepository bbsRepository){
        this.bbsRepository = bbsRepository;
    }

    // 견적문의 게시글 조회
    public List<BBSVO> findAll() {
        List<BBSVO> bbsList = bbsRepository.selectAll();
        bbsList.forEach(list -> System.out.println(list));
        return bbsList;
    }

    // 견적문의 게시글 입력
    public String createQuotation(BBSVO bbsvo){
        int result = bbsRepository.createQuotation(bbsvo);
        if (result > 0){
            return "등록 성공";
        } else {
            return "등록 실패";
        }
    }

    // 견적문의 게시글 삭제
    public String deleteQuotation(Integer quoteNumber){
        // 게시물 존재 여부 확인
        boolean exists = bbsRepository.existsByQuoteNumber(quoteNumber);
        if(!exists) {
            throw new IllegalArgumentException("해당 견적서를 찾을 수 없습니다: " + quoteNumber);
        }

        // IS_DELETED 1로 UPDATE
        int result = bbsRepository.deleteQuotation(quoteNumber);
        if(result > 0) {
            return "삭제 성공";
        }else {
            throw new IllegalArgumentException("이미 삭제된 견적서 입니다: " + quoteNumber);
        }
    }

    // 견적문의 게시글 수정
    public String updateQuotation(Integer quoteNumber, BBSVO bbsvo){
        // 게시물 존재 여부 확인
        boolean exists = bbsRepository.existsByQuoteNumber(quoteNumber);
        if(!exists) {
            throw new IllegalArgumentException("해당 견석서를 찾을 수 없습니다: " + quoteNumber);
        }

        // 수정
        bbsvo.setQuoteNumber(quoteNumber); // URL 경로 변수로 받은 quoteNumber 값을 세팅.
        int result = bbsRepository.updateQuotation(quoteNumber, bbsvo);
        if(result > 0){
            return "수정 성공";
        }else {
            return "이미 삭제된 견적서 입니다. 수정 불가합니다.";
        }
    }
}
