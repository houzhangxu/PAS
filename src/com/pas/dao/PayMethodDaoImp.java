package com.pas.dao;

import java.util.List;

import com.pas.model.PayMethodModel;

public interface PayMethodDaoImp {
	public PayMethodModel findPayMethodByPId(int p_id);
	public List<PayMethodModel> selectPayMethod();
	public void insertPayMethod(PayMethodModel pmm);
	public int deletePayMethodByPId(int p_id);
	public int updatePayMethodByPId(PayMethodModel pmm);
}
