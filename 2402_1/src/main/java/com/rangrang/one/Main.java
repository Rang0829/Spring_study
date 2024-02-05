package com.rangrang.one;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // private�̶� �ܺ� ȣ���� �Ұ�.
		
		// Reflection API? Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ����� �����Ѵ�.
		// java.lang.reflect��Ű�� ����.
		// Hello Ŭ������ Class ��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�.
		Class helloClass = Class.forName("day240202.Hello");
		Hello hello = (Hello) helloClass.newInstance(); // Class ��ü�� ���� ������ ��ü ����.
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private�� main()�� ȣ�� �����ϰ� �Ѵ�.
		
		main.invoke(hello); // hello.main() ȣ��� �Ȱ���.
	}
}
