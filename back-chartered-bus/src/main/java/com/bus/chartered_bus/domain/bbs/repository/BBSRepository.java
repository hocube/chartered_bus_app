package com.bus.chartered_bus.domain.bbs.repository;

import com.bus.chartered_bus.domain.bbs.model.BBSVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BBSRepository {

    private static final String NAME_SPACE = "bbsMapper.";

    // 생성자 주입 방식
    private final SqlSessionTemplate sqlSessionTemplate;

    public BBSRepository(SqlSessionTemplate sqlSessionTemplate){
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    // 견적문의 게시글 조회
    public List<BBSVO> selectAll(){
        List<BBSVO> bbsList = sqlSessionTemplate.selectList(NAME_SPACE + "selectAll");
        bbsList.forEach(list -> System.out.println(list));
        return bbsList;
    }

    // 견적문의 게시글 입력
    public int createQuotation(BBSVO bbsvo){
        return sqlSessionTemplate.insert(NAME_SPACE + "insertQuotation", bbsvo);
    }

    public int deleteQuotation(Integer quoteNumber){
        return sqlSessionTemplate.update(NAME_SPACE + "updateIsDeleted", quoteNumber);
    }
}
