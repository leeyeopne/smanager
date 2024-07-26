package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVo;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public MemberVO	 loginCheck(String id, String pw) {
		 return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> adminMemberList(String order, String members) {
		// TODO Auto-generated method stub
		return mapper.memberList(order, members);
	}

	@Override
	public List<StudentVo> studentList() {
		// TODO Auto-generated method stub
		return mapper.studentList();
	}

	@Override
	public boolean removeStudent(String sno) {
		// TODO Auto-generated method stub
		return mapper.deleteStudent(sno)==1;
	}

	@Override
	public boolean addStudent(StudentVo svo) {
		// TODO Auto-generated method stub
		return mapper.insertStudent(svo)==1;
	}

}
