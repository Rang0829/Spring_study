package com.rangrang.three;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// 서블릿이 초기화될 때 자동 호출되는 메서드
		// 1. 서블릿의 초기화 작업 담당
		System.out.println("[HelloServlet] init() is called.");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 입력
		// 2. 처리
		// 3. 출력
		System.out.println("[HelloServlet] service() is called.");
	}

	@Override
	public void destroy() {
		System.out.println("[HelloServlet] destroy() is called.");
	}

}
