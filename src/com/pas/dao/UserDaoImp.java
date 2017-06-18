package com.pas.dao;

import java.util.List;

import com.pas.model.UserModel;

public interface UserDaoImp {
	public UserModel findUserByID(int id);
	public List<UserModel> selectUser();
	public int findUIdByUsername(String username);
	public UserModel insertUser();
	public int findUIdByUsernameAndPassword(UserModel um);
}