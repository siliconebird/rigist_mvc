package com.mvc_model.dao;

import com.mvc_model.domain.Users;

public interface UserDao {
	/**
	 * ͨ���û�����xml���ݿ���Ѱ��ͬ���ͻ�����װ��users������
	 * @param username
	 * @return
	 */
	Users findUserByName(String username);
	
	/**
	 * ���û����浽xml���ݿ���
	 * @param user
	 */
	void saveUser(Users user);
	
	/**
	 * ��xml���ݿ���Ѱ���û�
	 * @param username
	 * @param password
	 * @return
	 */
	Users checkUser(String username, String password);

}
