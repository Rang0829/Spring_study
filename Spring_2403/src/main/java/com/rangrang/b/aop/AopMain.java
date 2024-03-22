package com.rangrang.b.aop;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AopMain {
    public static void main(String[] args) throws Exception {
        MyAdvice myAdvice = new MyAdvice();

        Class myClass = Class.forName("com.rangrang.b.aop.MyClass");
        Object obj = myClass.newInstance();

        for(Method m : myClass.getDeclaredMethods()) {
            myAdvice.invoke(m, obj, null);
        }
    }
}

class MyAdvice {
    Pattern p = Pattern.compile("a.*");

    boolean matches(Method m){
        Matcher matcher = p.matcher(m.getName());
        return matcher.matches();
    }
    void invoke(Method m, Object obj, Object... args) throws Exception {
        if(matches(m))
            System.out.println("[before]{");     // 부가 기능.

        m.invoke(obj, args); // 메서드 호출(핵심 기능). aaa(), bbb(), ccc() 호출.

        if(matches(m))
            System.out.println("}[after]");
    }
}

class MyClass {
    void aaa() {
        System.out.println("aaa() is called.");
    }

    void bbb() {
        System.out.println("bbb() is called.");
    }

    void ccc() {
        System.out.println("ccc() is called.");
    }
}