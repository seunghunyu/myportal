package com.bitacademy.myportal.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.exception.UserDaoException;
import com.bitacademy.myportal.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao  {
	@Autowired
	SqlSession sqlSession;
	@Override
	public int insert(UserVo vo) throws UserDaoException{
		// TODO Auto-generated method stub
		int insertedCount=0;
		try {
			sqlSession.insert("users.insert",vo);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("DAO:ERROR:"+e.getMessage());
			UserDaoException ex = new UserDaoException("회원가입중 오류!");
			ex.setVo(vo);
			throw ex;
		}
		return insertedCount;
	}

	@Override
	public UserVo selectUser(String email) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("users.selectUser",email);
	}

	@Override
	public UserVo selectUser(String email, String password) {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap();
		map.put("email",email);
		map.put("password",password);
		return sqlSession.selectOne("users.selectEmailPassWord",map);
	
	}

}
