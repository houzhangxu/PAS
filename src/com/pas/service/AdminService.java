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

	@Override
	public int doLogin(String username, String password) {
		// TODO Auto-generated method stub
		
		int aid = dao.getAIdByAdminname(username);
		
		if(aid==0){
			return -1;  //用户不存在
		}
		
		if(password.equals(dao.getPasswordByAId(aid))){
			return aid;  //用户存在
		}
		
		return 0;  //密码错误
	}

	@Override
	public boolean checkName(String username) {
		// TODO Auto-generated method stub
		if(dao.getAIdByAdminname(username) > 0){
			return false;
		}
		
		return true;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}
	
}
