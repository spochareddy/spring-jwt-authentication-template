package com.sindalah.repository;

import org.springframework.data.repository.CrudRepository;

import com.sindalah.entity.UserInfo;

public interface UserRepository extends CrudRepository<UserInfo, String> {
	
	UserInfo findByUserNameAndPassword(String userName, String password);
}
