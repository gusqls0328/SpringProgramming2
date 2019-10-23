package com.mycompany.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ch02")
@Controller
public class Chap02Controller {

	private static final Logger logger = LoggerFactory.getLogger(Chap02Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		logger.debug("이게 제대로 작동하나?");
		return "ch02/content";
	}
	
	@GetMapping("/getMethod")
	public String getMethod() {
		logger.debug("getMethod 실행됨");
		return "ch02/content";
	}
	
	@PostMapping("/postMethod")
	public String postMethod() {
		logger.debug("postMethod 실행됨");
		return "ch02/content";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "ch02/joinForm";
	}
	
	
	@PostMapping("/join")
	public String join() {
		logger.debug("이게 제대로 작동하나?");
		return "ch02/content";
	}
	
	
	
	
}
