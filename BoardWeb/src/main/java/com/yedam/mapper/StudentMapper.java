package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVo;

public interface StudentMapper {
	List<StudentVo> studentList();
	StudentVo selectOne(String sno);
	int insertStudent(StudentVo svo);
	
	// 로그인체크.
	MemberVO selectMember(@Param("id") String id,@Param("pw") String pw);
}
