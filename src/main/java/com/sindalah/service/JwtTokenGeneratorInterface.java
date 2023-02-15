package com.sindalah.service;

import java.util.Map;

import com.sindalah.entity.UserInfo;

public interface JwtTokenGeneratorInterface {

	Map<String, String> generateToken(UserInfo user);
}
