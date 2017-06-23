package com.pas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.OrderGoodsDaoImp;
import com.pas.model.OrderGoodsModel;

public class OrderGoodsService implements OrderGoodsServiceImp{

	@Autowired
	private OrderGoodsDaoImp dao;
	
	@Override
	public void addOrderGoods(OrderGoodsModel ogm) {
		// TODO Auto-generated method stub
		dao.insertOrderGoods(ogm);
	}

}
