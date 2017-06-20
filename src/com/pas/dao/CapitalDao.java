package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.CapitalModel;

public class CapitalDao implements CapitalDaoImp {
	@Autowired
	private SqlSession ss;
	@Override
	public CapitalModel findCapitalByUId(int u_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("capital.findCapitalByUId", u_id);
	}

	@Override
	public List<CapitalModel> selectCapital() {
		// TODO Auto-generated method stub
		List<CapitalModel> list=ss.selectList("capital.selectCapital");
		return list;
	}

	@Override
	public void insertCapital(CapitalModel cm) {
		// TODO Auto-generated method stub
		ss.insert("capital.insertCapital", cm);
	}

	@Override
	public int deleteCapitalByUId(int u_id) {
		// TODO Auto-generated method stub
		return ss.delete("capital.deleteCapitalByUId", u_id);
	}

	@Override
	public int updateCapitalByCId(CapitalModel cm) {
		// TODO Auto-generated method stub
		return ss.update("capital.updateCapitalByCId", cm);
	}

}
