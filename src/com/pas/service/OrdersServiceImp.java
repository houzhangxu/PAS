package com.pas.service;

import java.util.List;

import com.pas.model.OrdersModel;

public interface OrdersServiceImp {
	  public boolean createOrder(OrdersModel om);
	  public int getCount();
	  public List<OrdersModel> getAllOrders();
	  public OrdersModel findOrdersByOId(int o_id);
	  public List<OrdersModel> getAllOrdersEn(int statusNo);
	  public int updateStatus(OrdersModel om);
}
