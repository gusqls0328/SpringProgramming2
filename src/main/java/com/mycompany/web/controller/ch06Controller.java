package com.mycompany.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.web.dto.Ch06Dto;

@Controller
@RequestMapping("/ch06")
public class ch06Controller {

	public static final Logger logger = LoggerFactory.getLogger(ch06Controller.class);
	
	
	@RequestMapping("/content")
	public String content() {
		return "ch06/content"; // 다시 이쪽으로 옴
		
		
	}
	
	
	@PostMapping("/login")
	public String login(String mid, String mpassword, HttpSession session) {
		String loginResult = "";
		if(mid.equals("admin")) {
			if(mpassword.equals("iot12345")) {
				loginResult="success";
				
			} else {
				loginResult="wrongPassword";
			} 
				
			} else {
				
				loginResult="wrongId";
			} 
			
		session.setAttribute("loginResult", loginResult);
				
		return "redirect:/ch06/content"; // 새로운 경로 요청, jsp 이름이 아님

		
	}
	
	
	
	@RequestMapping("/logout")
	public String logout(String mid, String mpassword, HttpSession session) {
		session.removeAttribute("loginResult");
		return "redirect:/ch06/content";
		
	}
	
	@RequestMapping("/fileDownload") // 매개변수에 OutputStream os 변수를 선언해서 쓸 수 있지만, response를 또 써야하기 때문에 그냥 response 사용
	public void fileDownload(String fname, HttpServletResponse response, HttpServletRequest request ) throws Exception {
		logger.debug(fname);
		// 응답 헤더 추가
		ServletContext application = request.getServletContext();
		String mimeType = application.getMimeType(fname);
		response.addHeader("Content-Type", mimeType);
		// response.addHeader("Content-type", "image/jpeg"); // image/png, jpeg, application/json
		// 이걸로 적어도 됨 : response.setContentType("text/html;charset=UTF-8");
		
		
		String userAgent = request.getHeader("User-Agent");
		logger.debug(userAgent);
		String downloadName;
		if (userAgent.contains("Trident/7.0") || userAgent.contains("MSIE")) {
			// IE11 이하 버전
			
			downloadName = URLEncoder.encode(fname, "UTF-8");
			//logger.debug(downloadName);
			
		} else {
			
			downloadName = new String(fname.getBytes("UTF-8"), "ISO-8859-1");
		}
		
		
		
		String realPath = request.getServletContext().getRealPath("/resources/image/" + fname);
		// WebKit(크롬, 사파리, 파이어폭스, 오페라, 엣지) 기반 브라우져에서 한글 파일을 보호하기 위해
//		String downloadName = new String("풍경.jpg".getBytes("UTF-8"), "ISO-8859-1");
//		logger.debug(downloadName);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + downloadName + "\""); // disposition = 배치의 성격, attachment = 다운로드의 성격
		File file = new File(realPath);
		
		response.setHeader("Content-Length", String.valueOf(file.length()));
		
		// 응답 본문에 데이터 추가
		OutputStream os = response.getOutputStream(); // printWriter를 리턴함!
		
		
		 
		// 서블릿 컨텍스트가 어플리케이션이다 라고 생각해도 괜춘, 어플리케이션의 객체가 서블릿 컨텍스트
		// 서블릿 컨텍스트가 어플리케이션의 실행 주체임
		
		// InputStream is = new FileInputStream("C:/Temp/test1.db");
		// logger.debug("realPath");
		
		
		InputStream is = new FileInputStream(realPath);
		
		byte[] buffer = new byte[1024];
		while (true) {
			int readByte = is.read(buffer);
			if(readByte == -1) break; 
			os.write(buffer, 0, readByte);
			
		}
		os.flush();
		os.close();
		is.close();
		
	}
	
	
	// 제이슨에서 생성
	@RequestMapping("/jsonDownload1")
	public String jsonDownload1(Model model) {
		Ch06Dto board = new Ch06Dto();
		board.setBno(100);
		board.setBtitle("공부하고 싶다");
		board.setBcontent("하면되겠지 열공해라");
		board.setWriter("감못잡아");
		board.setDate(new Date());
		board.setHitcount(1);
		model.addAttribute("board", board);
		
		
		
		return "ch06/jsonDownload1";
		
	}
	
	// 컨트롤러에서 생성
	@RequestMapping("/jsonDownload2")
	public void jsonDonwload2(HttpServletResponse response) throws Exception {
		
		Ch06Dto board = new Ch06Dto();
		board.setBno(300);
		board.setBtitle("나는 오타쟁이");
		board.setBcontent("오타는 당연하지만 잡아라 못잡으면 빠가사리");
		board.setWriter("정신차려");
		
		board.setDate(new Date());
		board.setHitcount(1);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("bno", board.getBno());
		jsonObject.put("btitle", board.getBtitle());
		jsonObject.put("writer", board.getWriter());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		jsonObject.put("date", sdf.format(board.getDate()));
		jsonObject.put("hitcount", board.getHitcount());
		String json = jsonObject.toString();
		
		
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
		
		
	}
	
	
	
	
	}
	

