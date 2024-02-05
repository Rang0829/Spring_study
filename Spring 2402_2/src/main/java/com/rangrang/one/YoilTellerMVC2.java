package com.rangrang.one;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoilTellerMVC2 {
	    @RequestMapping("/getYoilMVC2") // http://localhost:8080/Spring%202402_2/getYoilMVC2?year=2024&month=2&day=5
//	    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	      public ModelAndView main(int year, int month, int day) throws IOException {
	     // 반환 타입이 ModelAndView
	    	
		 // 1. ModelAndView를 생성
	    ModelAndView mv = new ModelAndView(); 
		
		// 2. 유효성 검사 
		if(!isValid(year, month, day)) {
		   mv.setViewName("yoilError"); // View의 이름을 지정
	      return mv;
	   }
		
	   // 3. 처리
	 	char yoil = getYoil(year, month, day);

		// 4. ModelAndView에 작업한 결과를 저장 
	 	mv.addObject("year",  year);     	
	 	mv.addObject("month", month);     	
	 	mv.addObject("day",   day);     	
	 	mv.addObject("yoil", yoil);        
	   
	 	// 5. 작업 결과를 보여줄 View의 이름을 지정 
	 	mv.setViewName("yoil"); 
	 	
	 	// 6. ModelAndView를 반환
	 	return mv;
	}

		private char getYoil(int year, int month, int day) {
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, day);
			
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			return " 일월화수목금토".charAt(dayOfWeek);
		}

		private boolean isValid(int year, int month, int day) {
			return true;
		}
}
