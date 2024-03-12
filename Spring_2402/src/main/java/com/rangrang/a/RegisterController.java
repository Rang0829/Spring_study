package com.rangrang.a;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#"));
//		binder.setValidator(new UserValidator()); // UserValidator를 WebDataVinder의 로컬 validator로 등록한다.
//		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList = " + validatorList);
	}
	
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")   // 스프링 4.3버전 부터 가능
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		// 수동 검증 - Validator를 직접 생성하고, validate()를 직접 호출한다.
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result);  // BindingResult는 Error 인터페이스의 자손.		
		
		// User 객체를 검증한 결과, 에러가 있으면 hasErrors()가 참이 돼서 registerForm을 이용해 에러를 보여준다.
		if(result.hasErrors()) {
			return "registerForm";
		}
//		
//		// 1. 유효성 검사
//		if(!isVaild(user)) {
//			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
//			
//			m.addAttribute("msg", msg);   // model에 담아서 넘긴다.
//			return "forward:/register/add";
//			
//			return "redirect:/register/add?msg=" + msg;   // URL 재작성 (rewriting) - URL을 고쳐서 /register/add에게 GET 방식으로 URL을 전송하는 것.
//		}
		
		// 2. DB에 신규회원 정보 저장
		return "registerInfo";
	}

	private boolean isVaild(User user) {
		return true;
	}
}