package com.mycompany.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.web.dao.Ch09Dao3;

@Component("ch09Service3")
public class Ch09Service3 {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Service3.class);
	
	@Autowired
	private Ch09Dao3 ch09Dao3;
	
//	public Ch09Service3() {
//		logger.debug("###Ch09Service3의 객체를 생성했습니다.###");
//	}
//	
//	@Autowired
//	public void setCh09Dao3(Ch09Dao3 ch09Dao3) {
//		logger.debug("##setCh09Dao3 실행##");
//		this.ch09Dao3 = ch09Dao3;
//	}
	
	public void method3() {
		logger.debug("##Ch09Service3의 method3실행##");
		ch09Dao3.insert();
	}

}
