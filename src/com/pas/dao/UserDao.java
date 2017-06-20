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
	public void insertUser(UserModel um) {
		// ��user������ӵļ�¼
		ss.insert("user.insertUser", um);
	}

	@Override
	public int deleteUserByUId(int u_id) {
		// ����u_idɾ��user���еļ�¼
		return ss.delete("user.deleteUserByUId", u_id);
	}

	@Override
	public int updateUserByUId(UserModel um) {
		// ����u_id����user���е�һ����¼
		return ss.update("updateUserByUId", um);
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
