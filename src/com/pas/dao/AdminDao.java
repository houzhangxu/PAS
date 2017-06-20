package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.AdminModel;

public class AdminDao implements AdminDaoImp {
	@Autowired
	private SqlSession ss;

	@Override
	public AdminModel findAdminByAId(int a_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("admin.findAdminByAId", a_id);
	}

	@Override
	public List<AdminModel> selectAdmin() {
		// TODO Auto-generated method stub
		List<AdminModel> list=ss.selectList("admin.selectAdmin");
		return list;
	}

	@Override
	public int getAIdByAdminname(String admin_name) {
		// TODO Auto-generated method stub
		return ss.selectOne("admin.getAIdByAdminname", admin_name);
	}

	@Override
	public String getPasswordByAId(int a_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("admin.getPasswordByAId", a_id);
	}

	@Override
	public void insertAdmin(AdminModel am) {
		// TODO Auto-generated method stub
		ss.insert("admin.insertAdmin", am);
	}

	@Override
	public int deleteAdminByAId(int a_id) {
		// TODO Auto-generated method stub
		return ss.delete("admin.deleteAdminByAId", a_id);
	}

	@Override
	public int updateAdminByAId(AdminModel am) {
		// TODO Auto-generated method stub
		return ss.update("admin.updateAdminByAId", am);
	}

}
