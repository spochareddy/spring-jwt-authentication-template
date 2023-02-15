package com.sindalah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindalah.entity.UserInfo;
import com.sindalah.repository.UserRepository;
import com.sindalah.service.UserService;
import com.sindalahException.BusinessException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(UserInfo user) {
		userRepository.save(user);
	}

	@Override
	public UserInfo getUserByNameAndPassword(String name, String password) throws BusinessException {
		UserInfo user = userRepository.findByUserNameAndPassword(name, password);

		if (user == null) {
			throw new BusinessException("Invalid id and password");
		}
		log.info("inside getUserByNameAndPassword method ::" + user.toString());
		return user;
	}

}
