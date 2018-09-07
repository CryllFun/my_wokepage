package com.yy.service.impl;

import com.yy.dao.UserDao;
import com.yy.dao.impl.UserDaoImpl;
import com.yy.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean userLogin(String cardNo, String cardPwd) {
		return 	userDao.userLogin(cardNo, cardPwd);
	}

	@Override
	public float queryMoney(String cardNo) {
		
		return userDao.queryMoney(cardNo);
	}

	@Override
	public int takeMoney(String cardNo, float takeMoney) {
		float leftMoney = userDao.queryMoney(cardNo);
		if (leftMoney < takeMoney) {
			return -1;
		}else {
			/*if (takeMoney > 0) {
				userDao.updateMoney(takeMoney, cardNo);
			}*/
			return 0;
		}
	}
	
	
	
	
}
