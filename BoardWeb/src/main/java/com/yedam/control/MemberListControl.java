package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String order = req.getParameter("order");
		MemberService mem = new MemberServiceImpl();
		
		List<MemberVO> memL = mem.adminMemberList(order);
		req.setAttribute("love", memL);
		
		
		req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);
		
	}

}
