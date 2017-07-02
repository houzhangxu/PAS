package com.pas.service;

import java.util.List;

import com.pas.model.OrderGoodsModel;

public interface OrderGoodsServiceImp {
	public void addOrderGoods(OrderGoodsModel ogm);
	public List<OrderGoodsModel> selectOrderGoodsByOId(int o_id);
}
