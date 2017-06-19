package com.pas.dao;

import java.util.List;

import com.pas.model.CapitalModel;

public interface CapitalDaoImp {
	public CapitalModel findCapitalByUId(int u_id);
	public List<CapitalModel> selectCapital();
	public void insertCapital(CapitalModel cm);
	public void deleteCapitalByUId(int u_id);
	public void updateCapitalByCId(CapitalModel cm);
}
