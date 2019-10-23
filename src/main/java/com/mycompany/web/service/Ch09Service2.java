package com.mycompany.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.web.dao.Ch09Dao2;

@Component("ch09Service2")
public class Ch09Service2 {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch09Service2.class);
	
	@Autowired
	private Ch09Dao2 ch09Dao2;

//	public Ch09Service2() {
//		logger.debug("###Ch09Service2의 객체를 생성했습니다.###");
//	}
//	
//	@Autowired
//	public void setCh09Dao2(Ch09Dao2 ch09Dao2) {
//		logger.debug("##setCh09Dao2 실행##");
//		this.ch09Dao2 = ch09Dao2;
//	}
	
	public void method1() {
		logger.debug("##Ch09Service2의 method1실행##");
		ch09Dao2.insert();
	}

}
