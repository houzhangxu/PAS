package com.pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.GoodsTypeModel;

public class GoodsTypeService implements GoodsTypeServiceImp {

	@Autowired
	private GoodsDaoImp dao;

	@Override
	public List<GoodsTypeModel> GetAllGoodsTypeName(){
		
		List<GoodsTypeModel> list = dao.GetAllGoodsTypeName();
		
		return list;
	}
	
}
