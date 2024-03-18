//package com.rangrang.b;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
////@Component
//class Engine {}          // <bean id = "engine" class="com.rangrang.b.Engine"/>
//@Component class SuperEngine extends Engine {}
//@Component class TurboEngine extends Engine {}
//@Component class Door {}
//@Component class Car {
//    @Value("red") String color;
//    @Value("100") int oil;
////    @Autowired
////    @Qualifier("superEngine")
//    @Resource(name = "superEngine")   // byName
//    Engine engine;   // byType - @Autowired는 타입으로 먼저 검색 후 여러 개인 경우 이름으로 검색한다. - superEngine, turboEngine
//    @Autowired Door[] doors;
//
//    public Car() {}   // 기본 생성자 꼭 만들기.
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public void setOil(int oil) {
//        this.oil = oil;
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//
//    public void setDoors(Door[] doors) {
//        this.doors = doors;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "color='" + color + '\'' +
//                ", oil=" + oil +
//                ", engine=" + engine +
//                ", doors=" + Arrays.toString(doors) +
//                '}';
//    }
//}
//
//
//public class SpringDiTest {
//    public static void main(String[] args) {
//        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
////        Car car = (Car) ac.getBean("car"); // 아래와 같은 문장.
//        Car car = ac.getBean("car", Car.class);
////        Car car2 = (Car) ac.getBean(Car.class);
////        Engine engine = (Engine) ac.getBean("engine");    // byName
//////        Engine engine = (Engine) ac.getBean("Engine.class");  // byType - 같은 타입이 3개기 때문에 에러.
////        Door door = (Door) ac.getBean("door");
//
////        car.setColor("red");
////        car.setOil(100);
////        car.setEngine(engine);
////        car.setDoors(new Door[] { ac.getBean("door", Door.class), (Door) ac.getBean("door")});
//        System.out.println("car = " + car);
////        System.out.println("engine = " + engine);
//    }
//}
