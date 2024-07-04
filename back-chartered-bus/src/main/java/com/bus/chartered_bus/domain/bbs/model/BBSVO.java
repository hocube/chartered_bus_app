package com.bus.chartered_bus.domain.bbs.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BBSVO {

//  QUOTE_NUMBER  견적번호
//	APPLICANT_NAME  신청자 이름
//	PHONE_NUM  연락처
//	EMAIL  이메일
//	DRIVING_METHOD  운행방식
//	DESIRED_VEHICLE  희망차량
//	NUMBER_PEOPLE  인원 수
//	NUMBER_VEHICLE  차량 대수
//	DEPARTURE_DATE_TIME  출발 일시
//	ARRIVAL_DATE_TIME  도착 일시
//	DEPARTURE_CITY  출발장소(시,도)
//	DEPARTURE_DETAIL  출발장소(상세)
//	ARRIVAL_CITY  도착장소(시,도)
//	ARRIVAL_DETAIL  도착장소(상세)
//	REMARK  남길 말
//	TAX_INVOICE  세금 계산서
//	PARKING_FEE  주차비
//	TOLL_FEE  통행료
//	HOW_CHECK_QUOTATION  견적 확인 방법
//	PASSWORD  비밀번호
//	CURRENT_STATUS  현재 상황
//  CREATED_AT  게시글 등록일

    private Integer quoteNumber;
    private String applicantName;
    private String phoneNum;
    private String email;
    private String drivingMethod;
    private String desiredVehicle;
    private Integer numberPeople;
    private Integer numberVehicle;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private String departureCity;
    private String departureDetail;
    private String arrivalCity;
    private String arrivalDetail;
    private String remark;
    private String taxInvoice;
    private String parkingFee;
    private String tollFee;
    private String howCheckQuotation;
    private String password;
    private Integer isDeleted;                 // 삭제 여부   0: not deleted, 1: deleted
    private String currentStatus = "상담중";    // 기본값 설정
    private LocalDateTime createdAt;           // 데이터베이스에서 자동 설정

        //@NotNull(message = "ID에 Null 값을 넣을 수 없습니다.")
        //@NotBlank
}
