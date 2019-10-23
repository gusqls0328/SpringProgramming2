package com.mycompany.web.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ch04")
@Controller
public class Ch04Controller {

	private static final Logger logger = LoggerFactory.getLogger(Ch04Controller.class);
	
	@RequestMapping("/content")
	public String content(@RequestHeader("User-Agent") String userAgent,
			HttpServletRequest request) {
		logger.info("userAgent: " +userAgent);
		
		String browserKind = null;
		if (userAgent.contains("Chrome")) {
			browserKind = "chrome";
			
		} else if (userAgent.contains("Trident/7.0")) {
			browserKind = "IE 11";
			
		}
		
		request.setAttribute("browserKind", browserKind);
		
		
		return "ch04/content";
		
	}
	
	
	@RequestMapping("/setCookie")
	public String setCookie (HttpServletResponse response, String mname) {
//		try {
//		mname = URLEncoder.encode(mname, "UTF-8");
//		} catch(Exception e) {}
//		logger.debug("mname");
		Cookie cookie = new Cookie("mname", mname);
		//cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "ch04/content";
	}
	
	@RequestMapping("/getCookie")
	public String getCookie (//@CookieValue String name, 디폴트 밸류 값도 있음
			HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("mname")) {
//					try {
//					String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
//					} catch (Exception e) {}
					request.setAttribute("mname", cookie.getValue());
				}
				
			}
			
		}
		
		return "ch04/getCookie";
	}
	
	
}

