package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.BoardDao;
import com.bitacademy.myportal.vo.BoardVo;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDaoImpl;
	
	@Override
	public List<BoardVo> getList() {
		
		return boardDaoImpl.selectAll();
	}

	@Override
	public boolean write(BoardVo vo) {
		// TODO Auto-generated method stub
		return 1==boardDaoImpl.insert(vo);
	}	
}
