package com.mvc_model.service;

import com.mvc_model.domain.Users;
import com.mvc_model.exception.UserHasExistException;

public interface BussnisService {
	/**
	 * 用户信息注册
	 * @param user 用户信息
	 * @throws UserHasExistException 用户已经存在错误
	 */
	void regist(Users user) throws UserHasExistException;
	/**
	 *　用户登录
	 * @param username　登录账号
	 * @param password　登录密码
	 * @return　用户实例
	 */
	Users login(String username ,String password);
}
