package com.grizzly.service;

import com.grizzly.dao.LoginHibernateDao;
import com.grizzly.dao.LoginHibernateDaoImpl;
import com.grizzly.pojo.LoginPojo;
import com.grizzly.validation.WebsiteException;

public class LoginImpl implements LoginService{

	LoginHibernateDao login=new LoginHibernateDaoImpl();
	@Override
	public LoginPojo loginValidation(LoginPojo pojo) throws WebsiteException {
		
		LoginPojo serviceLoginPojo=login.loginValidation(pojo);
		return serviceLoginPojo;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int lockAccount(String username) throws WebsiteException {
		// TODO Auto-generated method stub
		int lock =login.lockAccount(username);
		return lock;
	}

	
}
