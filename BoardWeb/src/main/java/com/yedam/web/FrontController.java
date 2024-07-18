package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.AddBoardControl;
import com.yedam.control.Board;
import com.yedam.control.BoardForm;
import com.yedam.control.BoardListControl;
import com.yedam.control.StudentListControl;

/*
 * FontController 역할은 사용자의 모든 요청을 처리
 * 서블릿 a.do, sample.do
 * 객체생성 -> init -> service -> destroy.
 */
public class FrontController extends HttpServlet{
	Map<String, Control> map;
	
 public FrontController() {
	map = new HashMap<>();
 }
 @Override
	public void init(ServletConfig config) throws ServletException {
	 map.put("/boardList.do", new BoardListControl());
	 // 글 등록 구현 : 등록화면(boardForm.do) + DB 등록(addBoard.do) -> 글목록페이지이동
	 map.put("/boardForm.do", new BoardForm());
	 map.put("/addBoard.do", new AddBoardControl());
	 // 학생목록
	 map.put("/stdList.do", new StudentListControl());
	 map.put("/board.do", new Board());
	}
 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 //boardList.do - 목록. addBoard.do-등록
//	 System.out.println("service() 호출");
	 String uri = req.getRequestURI(); // url(http://localhost/boardweb/ vs uri
	 String context = req.getContextPath(); // 프로젝트 명
	 String path = uri.substring(context.length()); // "/boardList.do"
	 
	 System.out.println(path);
	 Control sub = map.get(path);
	 sub.exec(req, resp);
	 
	 
 	}
}