package com.grizzly.service;

import com.grizzly.pojo.LoginPojo;
import com.grizzly.validation.WebsiteException;

public interface LoginService {

	LoginPojo loginValidation(LoginPojo pojo) throws WebsiteException;
	int lockAccount(String username) throws WebsiteException;
}
