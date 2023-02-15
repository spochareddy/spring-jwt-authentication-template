package com.sindalah.service;

import com.sindalah.entity.UserInfo;
import com.sindalahException.BusinessException;

public interface UserService {

	void saveUser(UserInfo user);

	UserInfo getUserByNameAndPassword(String name, String password) throws BusinessException;
}
