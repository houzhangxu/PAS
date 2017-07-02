package com.pas.dao;

import java.util.List;

import com.pas.model.OrderGoodsModel;

public interface OrderGoodsDaoImp {
	public OrderGoodsModel findOrderGoodsById(int o_g_id);
	public List<OrderGoodsModel> selectOrderGoods();
	public void insertOrderGoods(OrderGoodsModel ogm);
	public int deleteOrderGoodsByOGId(int o_g_id);
	public int updateOrderGoodsByOGId(OrderGoodsModel ogm);
	public List<OrderGoodsModel> selectOrderGoodsByOId(int o_id);
}
