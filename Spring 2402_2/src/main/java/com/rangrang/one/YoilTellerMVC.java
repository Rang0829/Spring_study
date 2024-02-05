package com.rangrang.one;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost:8080/Spring%202402_2/getYoilMVC?year=2024&month=2&day=5
//    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
      public String main(int year, int month, int day, Model model) throws IOException {
    	
    	// 1. ��ȿ�� �˻�
    	if(!isValid(year, month, day))
    		return "yoilError";
    	
    	// 2. ���� ���
    	char yoil = getYoil(year, month, day);
        
    	
    	// 3. ����� ����� model�� ����
    	model.addAttribute("year", year);
    	model.addAttribute("month", month);
    	model.addAttribute("day", day);
    	model.addAttribute("yoil", yoil);
    	
        return "yoil"; // WEB-INF/views/yoil.jsp
    }

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);   // �Ͽ���:1, ������:2, ...
	}
}