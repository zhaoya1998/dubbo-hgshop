package com.zhaoya.hgshop.service.impl;

import java.util.Random;

import org.apache.dubbo.config.annotation.Service;

import com.zhaoya.hgshop.service.SecurityService;

@Service(interfaceClass = SecurityService.class)
public class SecurityServiceImpl implements SecurityService{

	@Override
	public String getKey() {
		Random random = new Random();
		// 
		 
		// TODO Auto-generated method stub
		String s = "";
		for (int i = 0; i < 16; i++) {
			char c = (char) ('a' + random.nextInt(26));
			s += c; 
		}
		return s;
	}

}