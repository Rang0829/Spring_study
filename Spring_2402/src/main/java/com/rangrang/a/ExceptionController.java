package com.rangrang.a;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	@ExceptionHandler(Exception.class)     // ���� ó���ϴ� �ֳ����̼�(�޼��尡 ó���� ���� ����)
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() in ExceptionController");
		System.out.println("m = " + m);
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})     // ���� ó���ϴ� �ֳ����̼�(�޼��尡 ó���� ���� ����)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}

	@RequestMapping("/ex")
	public String main(Model m) throws Exception {
		m.addAttribute("msg", "message from ExceptionController.main()");
		throw new Exception("���ܰ� �߻��߽��ϴ�.");
	}

	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�.");
	}
}
