package com.geekerstar.controller;

import com.geekerstar.bo.UserBO;
import com.geekerstar.pojo.Users;
import com.geekerstar.service.UserService;
import com.geekerstar.util.CookieUtils;
import com.geekerstar.util.JsonUtils;
import com.geekerstar.util.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.geekerstar.util.JSONResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public JSONResult regist(@RequestBody UserBO userBO,HttpServletRequest request, HttpServletResponse response){
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
        Users user = userService.createUser(userBO);

        user = setNullProperty(user);

        CookieUtils.setCookie(request,response,"user", JsonUtils.objectToJson(user),true);

        return JSONResult.ok();
    }


    @ApiOperation(value = "用户登录",notes = "用户登录",httpMethod = "POST")
    @PostMapping("/login")
    public JSONResult login(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 1.判断用户名和密码不为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        // 5.实现登录
        Users user = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));

        if (user == null){
            return JSONResult.errorMsg("用户名或密码错误");
        }

        user = setNullProperty(user);

        CookieUtils.setCookie(request,response,"user", JsonUtils.objectToJson(user),true);

        return JSONResult.ok(user);
    }

    private Users setNullProperty(Users user){
        user.setPassword(null);
        user.setMobile(null);
        user.setEmail(null);
        user.setRealname(null);
        user.setBirthday(null);
        user.setCreatedTime(null);
        user.setUpdatedTime(null);
        return user;
    }
}
