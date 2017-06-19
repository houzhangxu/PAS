package com.pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.GoodsTpyeDaoImp;
import com.pas.model.GoodsTypeModel;

public class GoodsTypeService implements GoodsTypeServiceImp {

	@Autowired
	private GoodsTpyeDaoImp dao;
	
	@Override
	public List<GoodsTypeModel> GetAllGoodsTypeName() {
		
		return dao.getGTIdAndName();
	}

}
