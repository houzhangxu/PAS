package com.pas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.GoodsDaoImp;
import com.pas.model.GoodsModel;

public class GoodsService implements GoodsServiceImp {

	@Autowired
	private GoodsDaoImp dao;
	
	@Override
	public GoodsModel findGoods(int goods_id) {
		
		return dao.findGoodsByGId(goods_id);
	}

}
