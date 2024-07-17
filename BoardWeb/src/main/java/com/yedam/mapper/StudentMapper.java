package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.StudentVo;

public interface StudentMapper {
	List<StudentVo> studentList();
	StudentVo selectOne(String sno);
	int insertStudent(StudentVo svo);
}
