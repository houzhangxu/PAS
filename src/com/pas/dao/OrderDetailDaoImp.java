package com.pas.dao;

import java.util.List;

import com.pas.model.OrderDetailModel;

public interface OrderDetailDaoImp {
	public OrderDetailModel findOrderDetailByODId(int o_d_id);
	public List<OrderDetailModel> selectOrderDetail();
	public void insertOrderDetail(OrderDetailModel odm);
	public int deleteOrderDetailByODId(int o_d_id);
	public int updateOrderDetailByODId(OrderDetailModel odm);
}
