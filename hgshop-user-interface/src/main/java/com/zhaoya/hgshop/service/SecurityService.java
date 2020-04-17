package com.zhaoya.hgshop.service;

public interface SecurityService {
	// 4. 密钥提供者微服随机生成16位密钥字符串，给8分
	String getKey();
}
