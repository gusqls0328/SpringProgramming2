package com.mycompany.web.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.web.service.Ch09MemberService;
import com.mycompany.web.service.Ch09Service;
import com.mycompany.web.service.Ch09Service2;
import com.mycompany.web.service.Ch09Service3;
import com.mycompany.web.service.Ch09Service4;

@Controller
@RequestMapping("/ch09")
public class Ch09Controller { // Autowired를 쓰려면 클래스가 관리 객체가 되어야함
	private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);
	
	@Autowired
	private Ch09Service ch09Service;
	@Autowired
	private Ch09Service2 ch09Service2;
	@Autowired
	private Ch09Service3 ch09Service3;
	@Autowired
	private Ch09Service4 ch09Service4;
	/*
	@Autowired
	private Ch09MemberService1 ch09MemberService1;
	@Autowired
	private Ch09MemberService2 ch09MemberService2;
	// 스프링은 싱글톤이기 때문에 동일한 객체가 만들어지지 않기 때문에 위와 같이 만들어도 됨 */

	@Resource(name="ch09MemberService") // 1,2 등 아이디만 바꿔주면됨
	private Ch09MemberService ch09MemberService;
	
//	public Ch09Controller() {
//		logger.debug("###Ch09Controller의 객체를 생성했습니다.###");
//	}
	
//	@Autowired
//	public void setCh09Service(Ch09Service ch09Service) {
//		logger.debug("##setCh09Service 실행##");
//		this.ch09Service = ch09Service;
//	}
	
//	@Autowired
//	public void setCh09Service2(Ch09Service2 ch09Service2) {
//		logger.debug("##setCh09Service2 실행##");
//		this.ch09Service2 = ch09Service2;
//	}
	
//	@Autowired
//	public void setCh09Service3(Ch09Service3 ch09Service3) {
//		logger.debug("##setCh09Service3 실행##");
//		this.ch09Service3 = ch09Service3;
//	}

	@RequestMapping("/content")
	public String content() {
		return "ch09/content";
	}
	
	@RequestMapping("/method1")
	public String method1() {
		logger.debug("##controller의 method1실행##");
		ch09Service.method1();
		return "redirect:/ch09/content";
	}
	
	@RequestMapping("/method2")
	public String method2() {
		logger.debug("##controller의 method2실행##");
		ch09Service2.method1();
		return "redirect:/ch09/content";
	}
	
	@RequestMapping("/method3")
	public String method3() {
		logger.debug("##controller의 method3실행##");
		ch09Service3.method3();
		return "redirect:/ch09/content";
	}
	
	@RequestMapping("/method4")
	public String method4() {
		logger.debug("##controller의 method4실행##");
		ch09Service4.method4();
		return "redirect:/ch09/content";
	}
	
}
