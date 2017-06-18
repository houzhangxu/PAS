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
		// ����u_id��ѯuser���е�һ����¼
		return ss.selectOne("user.findUserByUId",u_id);
	}

	@Override
	public List<UserModel> selectUser() {
		// ��ѯuser���еļ�¼
		List<UserModel> list=ss.selectList("user.selectUser");
		return list;
	}

	@Override
	public int findUIdByUsername(String username) {
		// ����username��ѯuser���е�u_id
		int u_id=ss.selectOne("user.findUIdByUsername", username);
		return u_id;
	}

	@Override
	public void insertUser(UserModel um) {
		// ��user������ӵļ�¼
		ss.insert("user.insertUser", um);
	}

	@Override
	public void deleteUserByUId(int u_id) {
		// ����u_idɾ��user���еļ�¼
		ss.delete("user.deleteUserByUId", u_id);
	}

	@Override
	public void updateUserByUId(UserModel um) {
		// ����u_id����user���е�һ����¼
		ss.update("updateUserByUId", um);
	}
}
