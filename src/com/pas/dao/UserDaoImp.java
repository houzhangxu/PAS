package com.pas.dao;

import java.util.List;

import com.pas.model.UserModel;

public interface UserDaoImp {
	public UserModel findUserByUId(int u_id);
	public List<UserModel> selectUser();
	public int getUIdByUsername(String username);
	public String getPasswordByUId(int u_id);
	public void insertUser(UserModel um);
	public int deleteUserByUId(int u_id);
	public int updateUserByUId(UserModel um);
	public int getCount();
}