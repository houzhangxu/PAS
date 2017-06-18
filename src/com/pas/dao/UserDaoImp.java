package com.pas.dao;

import java.util.List;

import com.pas.model.UserModel;

public interface UserDaoImp {
	public UserModel findUserByID(int u_id);
	public List<UserModel> selectUser();
	public int findUIdByUsername(String username);
	public void insertUser(UserModel um);
	public void deleteUserByUId(int u_id);
	public void updateUserByUId(UserModel um);
}