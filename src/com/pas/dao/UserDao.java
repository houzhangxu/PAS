package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.UserModel;

public class UserDao implements UserDaoImp{


	@Autowired
	private SqlSession ss;

	@Override
	public UserModel findUserByUId(int u_id) {
		return ss.selectOne("user.findUserByUId",u_id);
	}

	@Override
	public List<UserModel> selectUser() {
		List<UserModel> list=ss.selectList("user.selectUser");
		return list;
	}

	@Override
	public void insertUser(UserModel um) {
		ss.insert("user.insertUser", um);
	}

	@Override
	public int deleteUserByUId(int u_id) {
		return ss.delete("user.deleteUserByUId", u_id);
	}

	@Override
	public int updateUserByUId(UserModel um) {
		return ss.update("user.updateUserByUId", um);
	}

	@Override
	public int getUIdByUsername(String username) {
		// TODO Auto-generated method stub
		return ss.selectOne("user.getUIdByUsername",username);
	}

	@Override
	public String getPasswordByUId(int u_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("user.getPasswordByUId",u_id);
	}
}
