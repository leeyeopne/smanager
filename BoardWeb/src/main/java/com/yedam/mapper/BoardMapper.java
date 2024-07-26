package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVo;

/*
 * 글목록, 등록, 수정, 삭제, 단건조회
 * 기능정의 -> 기능구현(BoardMapper.xml)
 * */

public interface BoardMapper {
	List<BoardVO> selectList(SearchVO search);
	List<BoardVO> selectListPaging(SearchVO search); //페이지정보 -> 5건씩 출력
	int selectTotalCount(SearchVO search);
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int deleteBoard(int boardNo);
	BoardVO selectBoard(int boardNo);
	MemberVO selectMember(@Param("id")String id, @Param("pw") String pw);
	List<MemberVO> memberList(@Param("order") String order, @Param("members") String members);
	public List<StudentVo> studentList();
	int deleteStudent(String sno);
	int insertStudent(StudentVo svo);
	

	
	
}
