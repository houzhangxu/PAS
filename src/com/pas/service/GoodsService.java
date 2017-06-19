package com.pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.GoodsTypeModel;

public class GoodsService implements GoodsServiceImp {
	
	@Autowired
	private GoodsDaoImp dao;

	@Override
	public GoodsModel findGoods(int goods_id) {
		
		
		
		return dao.findGoodsByGoodsId(goods_id);
	}


}
