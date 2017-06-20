package com.pas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.UserDaoImp;
import com.pas.model.UserModel;

public class UserService implements UserServiceImp{

	@Autowired
	private UserDaoImp dao;

	@Override
	public int doLogin(String username, String password) {
		
		int uid = dao.getUIdByUsername(username);
		if(uid==0){
			return -1;
		}else{
			if(password.equals(dao.getPasswordByUId(uid))){
				return 1;
			}
		}
		
		return 0;
	}

	@Override
	public int doRegister(UserModel um) {
		
		dao.insertUser(um);
		
		if(um.getU_id()!=0){
			return um.getU_id();
		}
		
		
		return 0;
	}

	@Override
	public boolean checkName(String username) {
		
		if(dao.getUIdByUsername(username)>0){
			return true;
		}
		
		return false;
	}

	@Override
	public UserModel findUser(int u_id) {
		// TODO Auto-generated method stub
		
		return dao.findUserByUId(u_id);
	}
	

	
	
	
}
