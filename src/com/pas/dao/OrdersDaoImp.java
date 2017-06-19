package com.pas.dao;

import java.util.List;

import com.pas.model.OrdersModel;

public interface OrdersDaoImp {
	public OrdersModel findOrdersByOId(int o_id);
	public OrdersModel findOrdersByUId(int u_id);
	public List<OrdersModel> selectOrders();
	public void insertOrders(OrdersModel om);
	public void deleteOrdersByOId(int o_id);
	public void updateOrdersByOId(OrdersModel om);
}
