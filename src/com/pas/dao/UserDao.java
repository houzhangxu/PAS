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
		// 根据u_id查询user表中的一条记录
		return ss.selectOne("user.findUserByUId",u_id);
	}

	@Override
	public List<UserModel> selectUser() {
		// 查询user表中的记录
		List<UserModel> list=ss.selectList("user.selectUser");
		return list;
	}

	@Override
	public void insertUser(UserModel um) {
		// 在user表中添加的记录
		ss.insert("user.insertUser", um);
	}

	@Override
	public void deleteUserByUId(int u_id) {
		// 根据u_id删除user表中的记录
		ss.delete("user.deleteUserByUId", u_id);
	}

	@Override
	public void updateUserByUId(UserModel um) {
		// 根据u_id更新user表中的一条记录
		ss.update("updateUserByUId", um);
	}

	@Override
	public int getUIdByUsername(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPasswordByUId(int u_id) {
		// TODO Auto-generated method stub
		return null;
	}
}
