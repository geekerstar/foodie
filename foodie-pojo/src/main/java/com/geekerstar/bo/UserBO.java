package com.geekerstar.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author geekerstar
 * date: 2019/11/17 14:26
 * description:
 */
@ApiModel(value = "用户对象BO",description = "从客户端由用户传入的数据")
public class UserBO {

    @ApiModelProperty(value = "用户名",name = "username",example = "geekerstar",required = true)
    private String username;

    @ApiModelProperty(value = "密码",name = "password",example = "123456",required = true)
    private String password;

    @ApiModelProperty(value = "确认密码",name = "confirmPassword",example = "123456",required = true)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
