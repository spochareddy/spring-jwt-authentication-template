package com.sindalah.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sindalah.constants.FrameworkConstants;
import com.sindalah.entity.UserInfo;
import com.sindalah.service.JwtTokenGeneratorInterface;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtTokenGeneratorInterfaceImpl implements JwtTokenGeneratorInterface {

	@Override
	public Map<String, String> generateToken(UserInfo user) {

		String jwtToken = Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date())
				.setExpiration((new Date(System.currentTimeMillis() + FrameworkConstants.EXPIRATION_TIME)))
				.signWith(SignatureAlgorithm.HS256, FrameworkConstants.SECRET_KEY).compact();
		Map<String, String> jwtTokenGen = new HashMap<>();
		jwtTokenGen.put(FrameworkConstants.TOKEN, jwtToken);

		log.info("inside generateToken method ::" + jwtTokenGen);
		return jwtTokenGen;
	}
}
