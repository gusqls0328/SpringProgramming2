package com.mycompany.web2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// root에서 관리하게 만들기 위해
public class Ch09CommonService {
	private static final Logger logger = 
			LoggerFactory.getLogger(Ch09CommonService.class);
	
	@Autowired
	private Ch09CommonService ch09CommonService;
	
	public void method1() {
		logger.debug("실행");
		
	}
	
}
