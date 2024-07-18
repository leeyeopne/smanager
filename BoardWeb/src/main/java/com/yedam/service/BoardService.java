package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * MVC 패턴의 디자인에 따라서 Model 영역(service, dao)
 * 책 : 4강 MVC기반 웹프로젝트 참고
 *숙제 : 536페이지 MVC에 자세히 읽고 오세요.
 *
 * dao)
 * 등록 -> 수정 -> 조회
 * 수정 - 등록 - 조회
 * 조회 - 수정 - 등록
 * 
 * method) add + mod + select
 * method) mod + add + select
 * method) select+ add + mod
 * 
 * 서비스 부분이싿
 * service)
 * add + mod + select; 1중
 * 
 * dao)
 * method) add;
 * */
 
public interface BoardService {
	List<BoardVO> boardList();
	boolean addBoard(BoardVO board);
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	BoardVO getBoard(int boardNo);
}
