package com.mvc_model.service;

import com.mvc_model.domain.Users;
import com.mvc_model.exception.UserHasExistException;

public interface BussnisService {
	/**
	 * �û���Ϣע��
	 * @param user �û���Ϣ
	 * @throws UserHasExistException �û��Ѿ����ڴ���
	 */
	void regist(Users user) throws UserHasExistException;
	/**
	 *���û���¼
	 * @param username����¼�˺�
	 * @param password����¼����
	 * @return���û�ʵ��
	 */
	Users login(String username ,String password);
}
