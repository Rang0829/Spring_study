package com.rangrang.a;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST) // 500 에러에서 400 에러로 변경.
class MyException extends RuntimeException {
	MyException(String msg){      // 생성자.
		super(msg);
	}
	MyException() { this (""); }  // 기본 생성자.
}

@Controller
public class ExceptionController2 {
	
	@RequestMapping("/ex3")
	public String main() throws Exception {
		throw new MyException("예외가 발생했습니다.");
	}

	@RequestMapping("/ex4")
	public String main2() throws Exception {
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
}
