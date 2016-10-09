package com.mvc_model.service;

import com.mvc_model.dao.UserDao;
import com.mvc_model.dao.UserDaoImpl;
import com.mvc_model.dao.UserDaoMysqlImpl;
import com.mvc_model.domain.Users;
import com.mvc_model.exception.UserHasExistException;


public class BussnisServiceImpl implements BussnisService {
	UserDao dao = new UserDaoMysqlImpl();
	@Override
	public void regist(Users user) throws UserHasExistException {
		// TODO Auto-generated method stub
		if(dao.findUserByName(user.getUsername())!=null){
			throw new UserHasExistException("用户名"+user.getUsername()+"已经存在了");
		}else{
			dao.saveUser(user);
		}
	}

	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.checkUser(username,password);
	}
	
	

}
