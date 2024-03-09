package com.rangrang.a;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	}
	
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")   // ������ 4.3���� ���� ����
	public String save(User user, BindingResult result, Model m) throws Exception {
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		// 1. ��ȿ�� �˻�
		if(!isVaild(user)) {
			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.", "utf-8");
			
			m.addAttribute("msg", msg);   // model�� ��Ƽ� �ѱ��.
			return "forward:/register/add";
			
//			return "redirect:/register/add?msg=" + msg;   // URL ���ۼ� (rewriting) - URL�� ���ļ� /register/add���� GET ������� URL�� �����ϴ� ��.
		}
		
		// 2. DB�� �ű�ȸ�� ���� ����
		return "registerInfo";
	}

	private boolean isVaild(User user) {
		return true;
	}
}
