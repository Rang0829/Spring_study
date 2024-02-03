package day240202;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello {
	int iv = 10; // �ν��Ͻ� ����
	static int cv = 20; // static ����
	
	// 2. URL�� �޼��� ����
	@RequestMapping("/hello")
	private void main() { // �ν��Ͻ� �޼��� - iv, cv �� �� ��� ����.
		System.out.println("Hello - private");
		System.out.println(cv); // ����.
//		System.out.println(iv); // ����.
	}
	
	public static void main2() { // static �޼��� - cv�� ��� ����.
		System.out.println(cv); // ����.
//		System.out.println(iv); // ����.
		
	}
}
