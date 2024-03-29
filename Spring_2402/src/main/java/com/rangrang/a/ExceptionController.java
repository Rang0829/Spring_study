package
com.rangrang.a;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {

	@ExceptionHandler(Exception.class)     // 예외 처리하는 애노테이션(메서드가 처리할 예외 종류)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 상태 코드 200을 500으로 변경.
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() in ExceptionController");
		System.out.println("m = " + m);
//		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})     // 예외 처리하는 애노테이션(메서드가 처리할 예외 종류)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}

	@RequestMapping("/ex")
	public String main(Model m) throws Exception {
		m.addAttribute("msg", "message from ExceptionController.main()");
		throw new Exception("예외가 발생했습니다.");
	}

	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
}
