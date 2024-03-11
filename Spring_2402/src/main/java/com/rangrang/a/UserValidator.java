package com.rangrang.a;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
//		return User.class.equals(clazz); // 검증하려는 객체가 User 타입인지 확인.
		return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인.
	}

	@Override
	public void validate(Object target, Errors errors) { 
		System.out.println("UserValidator.validate() is called");

		User user = (User)target;   // target을 User로 형변환.
		
		String id = user.getId();
		
//		if(id==null || "".equals(id.trim())) {
//			errors.rejectValue("id", "required");   // id 필드에서 required 라는 에러 코드 저장.
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");   // 비었거나 공백이면 id에 required 에러 코드 저장.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		
		if(id==null || id.length() <  5 || id.length() > 12) {
			errors.rejectValue("id", "invalidLength");   // id 필드의 에러를 invalidLength 라는 에러 코드 저장.
		}
	}
}