package com.pas.service;

import java.util.List;

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
			return -1;  //用户不存在
		}
		
		if(password.equals(dao.getPasswordByUId(uid))){
			return uid;  //用户存在
		}
		
		return 0;  //密码错误
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
			return false;
		}
		
		return true;
	}

	@Override
	public UserModel findUser(int u_id) {
		// TODO Auto-generated method stub
		
		return dao.findUserByUId(u_id);
	}

	@Override
	public List<UserModel> getAllUser() {
		// TODO Auto-generated method stub
		return dao.selectUser();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}
	
	

	
	
	
}
