package com.mvc_model.dao;

import com.mvc_model.domain.Users;

public interface UserDao {
	/**
	 * 通过用户名在xml数据库中寻找同名客户并封装在users对象中
	 * @param username
	 * @return
	 */
	Users findUserByName(String username);
	
	/**
	 * 将用户保存到xml数据库中
	 * @param user
	 */
	void saveUser(Users user);
	
	/**
	 * 在xml数据库中寻找用户
	 * @param username
	 * @param password
	 * @return
	 */
	Users checkUser(String username, String password);

}
