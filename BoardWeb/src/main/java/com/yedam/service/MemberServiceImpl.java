package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public MemberVO	 loginCheck(String id, String pw) {
		 return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> adminMemberList(String order) {
		// TODO Auto-generated method stub
		return mapper.memberList(order);
	}

}
