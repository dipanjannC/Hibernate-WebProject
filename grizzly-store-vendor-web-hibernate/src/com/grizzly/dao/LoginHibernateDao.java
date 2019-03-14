package com.grizzly.dao;

import com.grizzly.pojo.LoginPojo;
import com.grizzly.validation.WebsiteException;

public interface LoginHibernateDao {

	LoginPojo loginValidation(LoginPojo pojo) throws WebsiteException;
	int lockAccount(String username) throws WebsiteException;
}
