package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.OrderDetailModel;

public class OrderDetailDao implements OrderDetailDaoImp {
	@Autowired
	private SqlSession ss;
	@Override
	public OrderDetailModel findOrderDetailByODId(int o_d_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("order_detail.findOrderDetailByODId", o_d_id);
	}

	@Override
	public List<OrderDetailModel> selectOrderDetail() {
		// TODO Auto-generated method stub
		List<OrderDetailModel> list=ss.selectList("order_detail.selectOrderDetail");
		return list;
	}

	@Override
	public void insertOrderDetail(OrderDetailModel odm) {
		// TODO Auto-generated method stub
		ss.insert("order_detail.insertOrderDetail", odm);
	}

	@Override
	public void deleteOrderDetailByODId(int o_d_id) {
		// TODO Auto-generated method stub
		ss.delete("order_detail.deleteOrderDetailByODId", o_d_id);
	}

	@Override
	public void updateOrderDetailByODId(OrderDetailModel odm) {
		// TODO Auto-generated method stub
		ss.update("order_detail.updateOrderDetailByODId", odm);
	}

}
