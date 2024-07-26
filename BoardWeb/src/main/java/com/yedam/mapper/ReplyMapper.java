package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> selectList(int boardNo); //댓글조회
	List<ReplyVO> selectListpaging(SearchVO search);
	int insertReply(ReplyVO rvo); //댓글등록
	int deleteReply(int replyNo); //댓글삭제
}
