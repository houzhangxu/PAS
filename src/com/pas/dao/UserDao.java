package com.pas.dao;

import java.util.List;

import com.pas.model.UserModel;

public class UserDao implements UserDaoImp{

	@Override
	public UserModel findUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
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
