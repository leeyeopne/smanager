package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVo;

public interface MemberService {
	MemberVO loginCheck(String id, String pw);
	List<MemberVO> adminMemberList(String order, String members);
	
	
	//학생목록조회
	List<StudentVo> studentList();
	boolean removeStudent(String sno);
	boolean addStudent(StudentVo svo);
}
