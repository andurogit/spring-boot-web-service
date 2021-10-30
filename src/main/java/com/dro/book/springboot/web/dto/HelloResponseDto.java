package com.dro.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter //모든 필드 get method
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 변수 생성자 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
