package com.yedam.common;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		BoardService svc = new BoardServiceImpl();
		svc.boardList().forEach(brd -> System.out.println(brd));
		svc.boardList().forEach(System.out::println);
		System.out.println("- End -");
		
//		SqlSession sqlSession = 
//				DataSource.getInstance().openSession(true); //<-true 자동 커밋
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		
//		BoardVO brd = new BoardVO();
//		brd.setTitle("메퍼테스트");
//		brd.setContent("조건이 제대로 되는지111");
//		brd.setWriter("newbile");
//		brd.setBoardNo(5);
////		if(mapper.updateBoard(brd)==1) {
////			System.out.println("OK");
////		}
//		
//		if(mapper.deleteBoard(6)==1) {
//			System.out.println("ok");
//		}
////		System.out.println(mapper.deleteBoard(6));
//		System.out.println(mapper.selectBoard(5));
//		
//		
//		mapper.selectList().forEach(board -> System.out.println(board.toString()));
		
//		System.out.println("- End -");
	}
}
