package com.mycompany.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service// ("ch09MemberService2") // 아이디는 달라야함, 동일하면 오류남
public class Ch09MemberService2 implements Ch09MemberService {

	private static final Logger logger = LoggerFactory.getLogger(Ch09MemberService2.class);
	
	@Override
	public void join() {
		logger.debug("실행");
		
	}
	
	@Override
	public void login() {
		logger.debug("실행");
		
	}
	
	
	
}
