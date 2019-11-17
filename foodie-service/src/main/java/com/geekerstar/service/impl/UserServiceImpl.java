package com.geekerstar.service.impl;

import com.geekerstar.bo.UserBO;
import com.geekerstar.enums.Sex;
import com.geekerstar.mapper.UsersMapper;
import com.geekerstar.pojo.Users;
import com.geekerstar.service.UserService;
import com.geekerstar.util.DateUtil;
import com.geekerstar.util.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author geekerstar
 * date: 2019/11/17 13:38
 * description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    private static final String USER_FACE ="";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Boolean queryUsernameIsExist(String username) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        Users users = usersMapper.selectOneByExample(example);
        return users != null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {
        String userId = sid.nextShort();
        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 默认用户昵称为用户名
        user.setNickname(userBO.getUsername());
        // 默认头像
        user.setFace(USER_FACE);
        // 默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        // 默认性别(保密）
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",password);
        Users user = usersMapper.selectOneByExample(example);
        return user;
    }
}
