package com.rangrang.one;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // private이라서 외부 호출이 불가.
		
		// Reflection API? 클래스 정보를 얻고 다룰 수 있는 강력한 기능을 제공한다.
		// java.lang.reflect패키지 제공.
		// Hello 클래스의 Class 객체(클래스의 정보를 담고 있는 개체)를 얻어온다.
		Class helloClass = Class.forName("day240202.Hello");
		Hello hello = (Hello) helloClass.newInstance(); // Class 객체가 가진 정보로 객체 생성.
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello); // hello.main() 호출과 똑같다.
	}
}
