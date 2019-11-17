package com.geekerstar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author geekerstar
 * date: 2019/11/16 22:19
 * description:
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {

//        logger.debug("debug: hello~");
//        logger.info("info: hello~");
//        logger.warn("warn: hello~");
//        logger.error("error: hello~");

        return "Hello World~";
    }

    @GetMapping("/setSession")
    public Object setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", "new user");
        session.setMaxInactiveInterval(3600);
        session.getAttribute("userInfo");
//        session.removeAttribute("userInfo");
        return "ok";
    }
}
