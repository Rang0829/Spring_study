package com.rangrang.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
//	@RequestMapping(value="/register/save", method= {RequestMethod.GET, RequestMethod.Post})
//	@RequestMapping("/register/add")   // 신규 회원 가입 화면
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")   // 스프링 4.3버전 부터 가능
	public String save(User user, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isVaild(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);   // model에 담아서 넘긴다.
			return "redirect:/register/add";
			
//			return "redirect:/register/add?msg=" + msg;   // URL 재작성 (rewriting) - URL을 고쳐서 /register/add에게 GET 방식으로 URL을 전송하는 것.
		}
		
		// 2. DB에 신규회원 정보 저장
		return "registerInfo";
	}

	private boolean isVaild(User user) {
		return true;
}
}
