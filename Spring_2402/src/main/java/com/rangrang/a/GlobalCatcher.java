package com.rangrang.a;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.rangrang.a") // 지정된 패키지에서 발생한 예외만 처리하고 패키지를 지정하지 않으면 모든 패키지의 예외를 처리.
public class GlobalCatcher {
	@ExceptionHandler(Exception.class)     // 예외 처리하는 애노테이션(메서드가 처리할 예외 종류)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})     // 예외 처리하는 애노테이션(메서드가 처리할 예외 종류)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
}
