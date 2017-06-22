package com.pas.service;

import java.util.List;

import com.pas.model.UserModel;

public interface UserServiceImp {
	public int doLogin (String username,String password);
	public int doRegister(UserModel um);
	public boolean checkName(String username);
	public UserModel findUser(int u_id);
	public List<UserModel> getAllUser();
	public int getCount();
}
