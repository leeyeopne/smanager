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
		String members = req.getParameter("members");
		MemberService mem = new MemberServiceImpl();
		members = members == null ? "User" : members;
		List<MemberVO> memL = mem.adminMemberList(order, members);
		req.setAttribute("love", memL);
		req.setAttribute("order", order);
		req.setAttribute("members", members);
		req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);
		
	}

}
