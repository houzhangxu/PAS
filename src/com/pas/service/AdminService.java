package com.pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.AdminDaoImp;
import com.pas.model.AdminModel;

public class AdminService implements AdminServiceImp{

	@Autowired
	private AdminDaoImp dao;
	
	@Override
	public int addAdmin(AdminModel am) {
		// TODO Auto-generated method stub
		dao.insertAdmin(am);
		return am.getA_id();
	}

	@Override
	public List<AdminModel> getAllAdmin() {
		// TODO Auto-generated method stub
		return dao.selectAdmin();
	}

	@Override
	public int updateAdmin(AdminModel am) {
		// TODO Auto-generated method stub
		return dao.updateAdminByAId(am);
	}

	@Override
	public int deleteAdmin(int a_id) {
		// TODO Auto-generated method stub
		return dao.deleteAdminByAId(a_id);
	}

	@Override
	public AdminModel findAdmin(int a_id) {
		// TODO Auto-generated method stub
		return dao.findAdminByAId(a_id);
	}
	
}
