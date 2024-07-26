package com.yedam.common;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		ReplyVO rvo = new ReplyVO();
//		rvo.setReplyContent("등록연습");
//		rvo.setReplyer("user03");
//		rvo.setReplyNo(149);
//		
//		if(svc.addReply(rvo)) {
//			System.out.println("등록완료!");
//		}
//		
//		if(svc.removeReply(1)) {
//			System.out.println("삭제완료!");
//		}		
		SearchVO search = new SearchVO();
		search.setBno(148);
		search.setPage(5);
		
		svc.replyList(search).forEach(System.out::println);
		System.out.println("-END-");
	}
}
