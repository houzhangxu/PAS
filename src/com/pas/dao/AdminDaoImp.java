package com.pas.dao;

import java.util.List;

import com.pas.model.AdminModel;

public interface AdminDaoImp {
	public AdminModel findAdminByAId(int a_id);
	public List<AdminModel> selectAdmin();
	public int findAIdByAdminname(String admin_name);
	public void insertAdmin(AdminModel am);
	public void deleteAdminByAId(int a_id);
	public void updateAdminByAId(AdminModel am);
}
