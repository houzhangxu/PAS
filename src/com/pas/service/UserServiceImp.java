package com.pas.service;

import com.pas.model.UserModel;

public interface UserServiceImp {
	public int doLogin (String username,String password);
	public int doRegister(UserModel um);
	public boolean checkName(String username);
}
