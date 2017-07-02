package com.pas.service;

import java.util.List;

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

	@Override
	public List<OrderGoodsModel> selectOrderGoodsByOId(int o_id) {
		// TODO Auto-generated method stub
		return dao.selectOrderGoodsByOId(o_id);
	}

}
