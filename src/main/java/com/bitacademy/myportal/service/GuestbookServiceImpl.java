package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.GuestbookDao;
import com.bitacademy.myportal.vo.GuestbookVo;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	GuestbookDao guestbookDaoImpl;
	@Override
	public List<GuestbookVo> getMessageList() {
		return guestbookDaoImpl.selectAll();
	}

	@Override
	public boolean writeMessage(GuestbookVo vo) {
		// TODO Auto-generated method stub
		int insertedCount=guestbookDaoImpl.insert(vo);
		return 1==insertedCount;
	}

	@Override
	public boolean deleteMessage(GuestbookVo vo) {
		// TODO Auto-generated method stub
		int deletedCount=guestbookDaoImpl.delete(vo);
		return 1==deletedCount;
		
	}

}