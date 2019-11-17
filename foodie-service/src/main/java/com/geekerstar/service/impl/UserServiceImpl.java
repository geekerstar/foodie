package com.geekerstar.service.impl;

import com.geekerstar.mapper.UsersMapper;
import com.geekerstar.pojo.Users;
import com.geekerstar.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author geekerstar
 * date: 2019/11/17 13:38
 * description:
 */
@Service
public class UserServiceImpl implements UserService {

    public UsersMapper usersMapper;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Boolean queryUsernameIsExist(String username) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        Users users = usersMapper.selectOneByExample(example);
        return users != null;
    }
}
