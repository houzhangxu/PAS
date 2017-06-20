package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.PayMethodModel;

public class PayMethodDao implements PayMethodDaoImp {
	@Autowired
	private SqlSession ss;
	@Override
	public PayMethodModel findPayMethodByPId(int p_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("pay_method.findPayMethodByPId", p_id);
	}

	@Override
	public List<PayMethodModel> selectPayMethod() {
		// TODO Auto-generated method stub
		List<PayMethodModel> list=ss.selectList("pay_method.selectPayMethod");
		return list;
	}

	@Override
	public void insertPayMethod(PayMethodModel pmm) {
		// TODO Auto-generated method stub
		ss.insert("pay_method.insertPayMethod", pmm);
	}

	@Override
	public int deletePayMethodByPId(int p_id) {
		// TODO Auto-generated method stub
		return ss.delete("pay_method.deletePayMethodByPId", p_id);
	}

	@Override
	public int updatePayMethodByPId(PayMethodModel pmm) {
		// TODO Auto-generated method stub
		return ss.update("pay_method.updatePayMethodByPId", pmm);
	}

}
