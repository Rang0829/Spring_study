package day240203;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice { 
	
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
int idx1 = (int)(Math.random()*6)+1; // 주사위 사진을 랜덤으로 보이게 하는 변수.
int idx2 = (int)(Math.random()*6)+1;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice" + idx1 + ".jpg'>");
		out.println("<img src='resources/img/dice" + idx2 + ".jpg'>");
		out.println("<body>");
		out.println("</html>");
	}
}
