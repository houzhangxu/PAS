package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.UserModel;

public class UserDao implements UserDaoImp{

	@Autowired
	private SqlSession ss;
	
	@Override
	public UserModel findUserByUId(int id) {
		// TODO Auto-generated method stub
		return ss.selectOne("user.findUserByUId",id);
	}


	@Override
	public List<UserModel> selectUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findUIdByUsername(String u_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserModel insertUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findUIdByUsernameAndPassword(UserModel um) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
