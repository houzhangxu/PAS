package com.pas.dao;

import java.util.List;

import com.pas.model.OrdersModel;

public interface OrdersDaoImp {
	public OrdersModel findOrdersByOId(int o_id);
	public OrdersModel findOrdersByUId(int u_id);
	public List<OrdersModel> selectOrders();
	public void insertOrders(OrdersModel om);
	public int deleteOrdersByOId(int o_id);
	public int updateOrdersByOId(OrdersModel om);
	public int getCount();
}
