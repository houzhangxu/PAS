package com.pas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.UserDaoImp;
import com.pas.model.UserModel;

public class UserService implements UserServiceImp{

	@Autowired
	private UserDaoImp dao;
	
	@Override
	public int login(String username, String password) {
		// TODO Auto-generated method stub
		UserModel um = new UserModel();
		um.setUsername(username);
		um.setPassword(password);
		
		int uid = dao.findUIdByUsernameAndPassword(um);
		
		if(uid == 0){
			return 0;
		}
		
		return uid;
	}

	
	
	
}
