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
	     // ��ȯ Ÿ���� ModelAndView
	    	
		 // 1. ModelAndView�� ����
	    ModelAndView mv = new ModelAndView(); 
		
		// 2. ��ȿ�� �˻� 
		if(!isValid(year, month, day)) {
		   mv.setViewName("yoilError"); // View�� �̸��� ����
	      return mv;
	   }
		
	   // 3. ó��
	 	char yoil = getYoil(year, month, day);

		// 4. ModelAndView�� �۾��� ����� ���� 
	 	mv.addObject("year",  year);     	
	 	mv.addObject("month", month);     	
	 	mv.addObject("day",   day);     	
	 	mv.addObject("yoil", yoil);        
	   
	 	// 5. �۾� ����� ������ View�� �̸��� ���� 
	 	mv.setViewName("yoil"); 
	 	
	 	// 6. ModelAndView�� ��ȯ
	 	return mv;
	}

		private char getYoil(int year, int month, int day) {
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, day);
			
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			return " �Ͽ�ȭ�������".charAt(dayOfWeek);
		}

		private boolean isValid(int year, int month, int day) {
			return true;
		}
}
