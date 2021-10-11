package com.bitacademy.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.exception.UserDaoException;
import com.bitacademy.myportal.repository.UserDao;
import com.bitacademy.myportal.repository.UserDaoImpl;
import com.bitacademy.myportal.vo.UserVo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDaoImpl;
	@Override
	public boolean join(UserVo vo) throws UserDaoException{
		// TODO Auto-generated method stub
		int insertedCount=userDaoImpl.insert(vo);
		return 1==insertedCount;
	}

	@Override // 중복체크용
	public UserVo getUser(String email) {
		// TODO Auto-generated method stub
		
		return userDaoImpl.selectUser(email);
	}

	@Override //로그인용
	public UserVo getUser(String email, String password) {
		// TODO Auto-generated method stub
		return userDaoImpl.selectUser(email,password);
	}

}
