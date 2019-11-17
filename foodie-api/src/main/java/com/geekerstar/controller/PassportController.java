package com.geekerstar.controller;

import com.geekerstar.bo.UserBO;
import com.geekerstar.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.geekerstar.util.JSONResult;

/**
 * @author geekerstar
 * date: 2019/11/17 13:46
 * description:
 */
@Api(value = "注册登录",tags = "用于注册登录的相关接口")
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在",httpMethod = "GET")
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


    @ApiOperation(value = "用户注册",notes = "用户注册",httpMethod = "POST")
    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBO userBO){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        // 1.判断用户名和密码不为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)){
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        // 2.查询用户名是否存在
        Boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist){
            return JSONResult.errorMsg("用户名已存在");
        }

        // 3.密码长度不能少于六位
        if (password.length() < 6){
            return JSONResult.errorMsg("密码长度不能少于6位 ");
        }

        // 4.判断两次密码是否一致
        if (!password.equals(confirmPassword)){
            return JSONResult.errorMsg("两次密码长度输入不一致");
        }

        // 5.实现注册
        userService.createUser(userBO);
        return JSONResult.ok();
    }


}
