package com.geekerstar.service;

import com.geekerstar.bo.UserBO;
import com.geekerstar.pojo.Users;

/**
 * @author geekerstar
 * date: 2019/11/17 13:36
 * description:
 */

public interface UserService {


    /**
     * 判断用户是否存在
     *
     * @param username
     * @return
     */
    Boolean queryUsernameIsExist(String username);


    /**
     * 注册
     *
     * @param userBO
     * @return
     */
    Users createUser(UserBO userBO);

}
