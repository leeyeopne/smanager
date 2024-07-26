package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchVO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
    SqlSession sqlSession = DataSource.getInstance().openSession(true);//자동커밋
    ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);


    @Override
    public List<ReplyVO> replyList(SearchVO search) {
        return mapper.selectListpaging(search);
    }

    @Override
    public boolean addReply(ReplyVO rvo) {
        return mapper.insertReply(rvo) == 1;
    }

    @Override
    public boolean removeReply(int replyNo) {
        return mapper.deleteReply(replyNo) == 1;
    }


}