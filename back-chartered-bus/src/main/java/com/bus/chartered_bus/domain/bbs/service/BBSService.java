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
        int result = bbsRepository.deleteQuotation(quoteNumber);
        if(result > 0) {
            return "삭제 성공";
        }else {
            return "이미 삭제된 견적서 입니다.";
        }
    }
}
