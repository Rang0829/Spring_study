package com.rangrang.a;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.rangrang.a") // ������ ��Ű������ �߻��� ���ܸ� ó���ϰ� ��Ű���� �������� ������ ��� ��Ű���� ���ܸ� ó��.
public class GlobalCatcher {
	@ExceptionHandler(Exception.class)     // ���� ó���ϴ� �ֳ����̼�(�޼��尡 ó���� ���� ����)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})     // ���� ó���ϴ� �ֳ����̼�(�޼��尡 ó���� ���� ����)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
}
