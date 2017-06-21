package com.pas.service;

import java.util.List;

import com.pas.model.AdminModel;

public interface AdminServiceImp {
	public int addAdmin(AdminModel am);
	public List<AdminModel> getAllAdmin();
	public int updateAdmin(AdminModel am);
	public int deleteAdmin(int a_id);
	public AdminModel findAdmin(int a_id);
}
