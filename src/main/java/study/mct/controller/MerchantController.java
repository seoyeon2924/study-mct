package study.mct.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {

/**
 * 등록 V1: 요청 값으로 엔티티를 직접 받는다.
 * 문제점
 * - 엔티티에 프레젠테이션 계층을 위한 로직이 추가된다.
 * - 엔티티에 API 검증을 위한 로직이 들어간다. (@NotEmpty 등등)
 * - 실무에서는 회원 엔티티를 위한 API가 다양하게 만들어지는데, 한 엔티티에 각각의 API를 위한 모든 요청 요구사항을 담기는 어렵다.
 * - 엔티티가 변경되면 API 스펙이 변한다.
 * 결론
 * - API 요청 스펙에 맞추어 별도의 DTO를 파라미터로 받는다. */


}
