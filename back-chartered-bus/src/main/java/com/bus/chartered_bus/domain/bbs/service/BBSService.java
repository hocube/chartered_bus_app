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

    public String createQuotation(BBSVO bbsvo){
        int result = bbsRepository.createQuotation(bbsvo);
        if (result > 0){
            return "등록 성공";
        } else {
            return "등록 실패";
        }
    }
}
