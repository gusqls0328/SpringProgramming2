package com.mycompany.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.web.dao.Ch09Dao;

//@Component("ch09Service")

@Service // 이런거를 사용하려면 생성자에 매개값이 있으면 안되, 그냥 없는게 좋음
public class Ch09Service {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Service.class);
	
//	public Ch09Service(String arg1, int arg2) {
//		
//		
//	}
	
//	public Ch09Service() {
//		logger.debug("###Ch09Service의 객체를 생성했습니다.###");
//	}
	
	@Autowired
	private Ch09Dao ch09Dao;
	
//	public void setCh09Dao(Ch09Dao ch09Dao) {
//		logger.debug("##setCh09Dao 실행##");
//		this.ch09Dao = ch09Dao;
//	}
	
	public void method1() {
		logger.debug("##method1 실행##");
		ch09Dao.insert();
	}
}
