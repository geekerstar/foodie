package com.geekerstar.controller;

import com.geekerstar.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geekerstar.util.JSONResult;

/**
 * @author geekerstar
 * date: 2019/11/17 13:46
 * description:
 */
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String username){
        // 1.判断用户名不能为空
        if (StringUtils.isBlank(username)){
            return JSONResult.errorMsg("用户名不能为空");
        }
        // 2.查找用户名是否存在
        Boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist){
            return JSONResult.errorMsg("用户名已存在");
        }
        // 3.请求成功，用户名没有重复
        return JSONResult.ok();
    }


}
