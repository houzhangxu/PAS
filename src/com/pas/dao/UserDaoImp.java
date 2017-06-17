package com.pas.dao;

import com.pas.model.UserModel;

public interface UserDaoImp {
	public UserModel findUserByID(int id);
	public int findUIdByUsernameAndPassword(UserModel um);
}