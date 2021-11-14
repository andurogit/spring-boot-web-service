package com.dro.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션 생성 위치
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // 어노테이션 클래스로 지정 name -> LoginUser
}
