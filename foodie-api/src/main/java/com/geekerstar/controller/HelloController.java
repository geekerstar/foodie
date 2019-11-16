package com.geekerstar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author geekerstar
 * date: 2019/11/16 22:19
 * description:
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {

        return "Hello World~";
    }
}
