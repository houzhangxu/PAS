package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.OrderGoodsModel;

public class OrderGoodsDao implements OrderGoodsDaoImp {
	@Autowired
	private SqlSession ss;
	@Override
	public OrderGoodsModel findOrderGoodsById(int o_g_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("order_goods.findOrderGoodsById", o_g_id);
	}

	@Override
	public List<OrderGoodsModel> selectOrderGoods() {
		// TODO Auto-generated method stub
		List<OrderGoodsModel> list=ss.selectList("order_goods.selectOrderGoods");
		return list;
	}

	@Override
	public void insertOrderGoods(OrderGoodsModel ogm) {
		// TODO Auto-generated method stub
		ss.insert("order_goods.insertOrderGoods", ogm);
	}

	@Override
	public void deleteOrderGoodsByOGId(int o_g_id) {
		// TODO Auto-generated method stub
		ss.delete("order_goods.deleteOrderGoodsByOGId", o_g_id);
	}

	@Override
	public void updateOrderGoodsByOGId(OrderGoodsModel ogm) {
		// TODO Auto-generated method stub
		ss.update("order_goods.updateOrderGoodsByOGId", ogm);
	}

}
