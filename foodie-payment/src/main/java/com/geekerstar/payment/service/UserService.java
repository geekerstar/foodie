package com.geekerstar.payment.service;


import com.geekerstar.payment.pojo.Users;

public interface UserService {

	/**
	 * @Description: 查询用户信息
	 */
	public Users queryUserInfo(String userId, String pwd);

}

