package com.rangrang.c.controller;

import com.rangrang.c.domain.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleRestController {
//    @GetMapping("/ajax")
//    public String ajax() {
//        return "ajax";
//    }

    @PostMapping("/send")
//    @ResponseBody
    public Person test(@RequestBody Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }

    @PostMapping("/send")
//    @ResponseBody
    public Person test2(@RequestBody Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }
}