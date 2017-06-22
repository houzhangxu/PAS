package com.pas.dao;

import java.util.List;

import com.pas.model.AdminModel;

public interface AdminDaoImp {
	public AdminModel findAdminByAId(int a_id);
	public List<AdminModel> selectAdmin();
	public int getAIdByAdminname(String admin_name);
	public String getPasswordByAId(int a_id);
	public void insertAdmin(AdminModel am);
	public int deleteAdminByAId(int a_id);
	public int updateAdminByAId(AdminModel am);
	public int getCount();
}
