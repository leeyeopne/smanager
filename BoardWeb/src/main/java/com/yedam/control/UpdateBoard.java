package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class UpdateBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardService svc = new BoardServiceImpl();
		String writer = req.getParameter("writer") ;
		String content = req.getParameter("content");
		String title = req.getParameter("title");
		int bno = Integer.parseInt(req.getParameter("bno"));
		BoardVO bvo= new BoardVO();
		bvo.setWriter(writer);
		bvo.setContent(content);
		bvo.setTitle(title);
		bvo.setBoardNo(bno);
		System.out.println(bvo);
		if(svc.modifyBoard(bvo)) {
			// 목록으로 이동
			resp.sendRedirect("boardList.do");
		}else {
			// 수정페이지로 이동.
			resp.sendRedirect("modifyBoard.do?bno=" + bno);
		}
	}

}
