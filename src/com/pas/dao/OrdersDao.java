package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.OrdersModel;

public class OrdersDao implements OrdersDaoImp {
	@Autowired
	private SqlSession ss;
	@Override
	public OrdersModel findOrdersByOId(int o_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("orders.findOrdersByOId", o_id);
	}

	@Override
	public OrdersModel findOrdersByUId(int u_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("orders.findOrdersByUId", u_id);
	}

	@Override
	public List<OrdersModel> selectOrders() {
		// TODO Auto-generated method stub
		List<OrdersModel> list=ss.selectList("orders.selectOrders");
		return list;
	}

	@Override
	public void insertOrders(OrdersModel om) {
		// TODO Auto-generated method stub
		ss.insert("orders.insertOrders", om);
	}

	@Override
	public void deleteOrdersByOId(int o_id) {
		// TODO Auto-generated method stub
		ss.delete("orders.deleteOrdersByOId", o_id);
	}

	@Override
	public void updateOrdersByOId(OrdersModel om) {
		// TODO Auto-generated method stub
		ss.update("orders.updateOrdersByOId", om);
	}

}
