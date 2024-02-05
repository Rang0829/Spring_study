package com.rangrang.one;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTeller2 {
    @RequestMapping("/getYoil2") // http://localhost:8080/Spring%202402_2/getYoil2?year=2024&month=2&day=5
//    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
      public void main(int year, int month, int day, HttpServletResponse response) throws IOException {
    	
    	Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);   // �Ͽ���:1, ������:2, ... 

        response.setContentType("text/html");    // ������ ������ html�� ����
        response.setCharacterEncoding("utf-8");  // ������ ���ڵ��� utf-8�� ����
        PrintWriter out = response.getWriter();  // response ��ü���� ���������� ��� ��Ʈ��(out)�� ��´�.
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println(year + "�� " + month + "�� " + day + "���� ");
        out.println(yoil + "�����Դϴ�.");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}