package com.mycompany.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.web.dto.Ch10Board;
import com.mycompany.web.dto.Ch10Member;
import com.mycompany.web.service.Ch10Service;
import com.mycompany.web.service.LoginResult;

@Controller
@RequestMapping("/ch10")
public class Ch10Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);
	
	// @Autowired
	@Resource(name = "dataSource")
	private DataSource dataSource;

	@RequestMapping("/content")

	public String content() {

		return "ch10/content";
	}

	@RequestMapping("/connTest")
	public void connTest(HttpServletResponse response) {
		boolean result = false;

		try {
			// 커넥션 풀에서 연결된 커넥션 대여
			Connection conn = dataSource.getConnection();
			if (conn != null)
				result = true;

			// 커넥션 풀로 커넥션을 반납
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", result);
			pw.print(jsonObject.toString());
			pw.flush();
			pw.close();
		} catch (IOException e) {
		}

	}

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@RequestMapping("/getMember")
	public String getMember(String mid, Model model) {

		Ch10Member member = sqlSessionTemplate.selectOne("member.selectMember-ByMid", mid);
		model.addAttribute("member", member);
		return "ch10/getMember";

	}

	@Autowired
	private Ch10Service service;

	@RequestMapping("/boardList")
	public String boardList(Model model, @RequestParam(defaultValue = "1") int pageNo, HttpSession session) {
		session.setAttribute("pageNo", pageNo);	
		
		//페이지당 행수
		int rowsPerPage = 10;
		//이전, 다음을 클릭했을 때 나오는 페이지 수
		int pagesPerGroup = 5;
		//전체 게시물 수
		int totalRowNum = service.getTotalRowNo();
		//전체 페이지 수
		int totalPageNum = totalRowNum / rowsPerPage;
		if(totalRowNum % rowsPerPage != 0) totalPageNum++;
		//전체 그룹 수
		int totalGroupNum = totalPageNum / pagesPerGroup;
		if(totalPageNum % pagesPerGroup != 0) totalGroupNum++;
		
		//현재 페이지의 그룹번호
		int groupNo = (pageNo-1)/pagesPerGroup + 1;
		//현재 그룹의 시작 페이지 번호
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		//현재 그룹의 마지막 페이지 번호
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if(groupNo == totalGroupNum) endPageNo = totalPageNum;
		
		//현재 페이지의 시작 행번호
		int startRowNo = (pageNo-1)*rowsPerPage + 1;
		//현재 페이지의 끝 행번호
		int endRowNo = pageNo*rowsPerPage;
		if(pageNo == totalPageNum) endRowNo = totalRowNum;
		
		//현재 페이지의 게시물 가져오기
		List<Ch10Board> boardList = service.getBoardList(startRowNo, endRowNo);
		
		//JSP로 페이지 정보 넘기기
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("totalGroupNum", totalGroupNum);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("boardList", boardList);
		
		return "ch10/boardList";
	}

//	@RequestMapping("/writeBoard")
//	public String writeBoard() {
//		for (int i = 1; i <= 105; i++) {
//			Ch10Board board = new Ch10Board();
//			board.setBtitle("제목" + i);
//			board.setBcontent("내용" + i);
//			board.setBwriter("fall");
//			service.writeBoard(board);
//		}
//		return "redirect:/ch10/boardList";
//	}
	
	
	@RequestMapping("/writeBoardForm")
	public String writeBoardForm(HttpSession session) {
		
		String mid = (String)session.getAttribute("mid"); // 세션에 저장되어 있는 mid를 가져와봐라 하는 것, null이 나오면 없다는것임=로그인이 되지 않았다, 세션에 한번도 로그인한적이 없다 
		if(mid == null) {
			return "redirect:/ch10/loginForm";
			
		}
		
		return "ch10/writeBoardForm";
		
	}
	
	@RequestMapping("/writeBoard")
	public String writeBoard(Ch10Board board, HttpSession session) {
		board.setBwriter((String)session.getAttribute("mid"));
		//logger.debug("dao 실행 전: " + board.getBno());
		service.writeBoard(board);
		//logger.debug("dao 실행 후: " + board.getBno());
		return "redirect:/ch10/boardList";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm(String error, Model model) {
		
		if (error != null) {
			if (error.equals("fail_mid")) {
				
				model.addAttribute("midError", "*ID가 존재하지 않습니다");
			} else if (error.equals("fail_mpassword")) {
				
				model.addAttribute("mpasswordError", "*비밀번호가 존재하지 않습니다");
			}
			
		} 
		
		
		return "ch10/loginForm";
	}
	
	@PostMapping("/login")
	public String login(String mid, String mpassword, HttpSession session) { //, Model model
		
		LoginResult result = service.login(mid, mpassword); // 로그인은 비즈니스 메소드기 때문에 서비스에 넘기는것이 더 좋음
		// int result =, static final로 된 상수를 쓰던가
		if (result == LoginResult.FAIL_MID) {
			//model.addAttribute("midError", "*ID가 존재하지 않습니다"); //모델을 쓴 이유는 리턴값으로 전달할 목적인데, 리퀘스트에 전달하는거랑 같은데 리다이렉트는 재요청이기 때문에 다시 쓸수없음
			
//			session.setAttribute("midError", "*ID가 존재하지 않습니다");
//			return "redirect:/ch10/loginForm";
			return "redirect:/ch10/loginForm?error=fail_mid";
		} else if (result == LoginResult.FAIL_MPASSWORD) {
//			session.setAttribute("mpasswordError", "*비밀번호가 존재하지 않습니다");
//			return "redirect:/ch10/loginForm";
			return "redirect:/ch10/loginForm?error=fail_mpassword";
		} 
		
		session.setAttribute("mid", mid);
		return "redirect:/ch10/boardList";
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("mid");
		return "redirect:/ch10/boardList";
	}
	
	
	@GetMapping("/join")
	public String joinForm() {
		return "ch10/joinForm";
		
		
	}
	
	@PostMapping("/join")
	public String join(Ch10Member member) {
		service.join(member);
		return "redirect:/ch10/loginForm";
		
		
	}
	
	
	@RequestMapping("/checkMid")
	public void checkMid(String mid, HttpServletResponse response) throws Exception {
		boolean result = service.checkMid(mid);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", result);
		pw.print(jsonObject.toString());
		pw.flush();
		pw.close();
	}
	
	@RequestMapping("/boardDetail")
	public String boardDetail(int bno, Model model) {
		service.increaseHitcount(bno);
		Ch10Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		return "ch10/boardDetail";
		
	}
	
	
	@GetMapping("/updateBoard")
	public String updateBoardForm(int bno, Model model) {
		Ch10Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		return "ch10/updateBoardForm";
		
		
	}
	
	
	@PostMapping("/updateBoard")
	public String updateBoard(Ch10Board board, HttpSession session) {
		service.updateBoard(board);
		int pageNo = (Integer)session.getAttribute("pageNo");
		return "redirect:/ch10/boardList?pageNo=" + pageNo;
		
		
	}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(int bno, HttpSession session) {
		service.deleteBoard(bno);
		int pageNo = (Integer)session.getAttribute("pageNo");
		return "redirect:/ch10/boardList?pageNo=" + pageNo;
		
	}
	
	@RequestMapping("/limitAmountOfBoardList")
	public String limitAmountOfBoardList(int bno) {
		service.limitAmountOfBoardList(bno);
		return "ch10/boardList";
		
	}
	
}
