package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.BoardVo;
@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	SqlSession sqlSession;
	@Override
	public List<BoardVo> selectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.selectAll");
	}

	@Override
	public int insert(BoardVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board.insert", vo);
	}
	
}
