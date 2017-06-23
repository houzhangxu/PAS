package com.pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.OrdersDaoImp;
import com.pas.model.OrdersModel;
import com.pas.model.ShoppingCartModel;

public class OrdersService implements OrdersServiceImp {

	@Autowired
	private OrdersDaoImp dao;
	
	@Override
	public boolean createOrder(OrdersModel om) {
		dao.insertOrders(om);
		if(om.getO_id() > 0){
			return true;
		}
		return false;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}


	@Override
	public List<OrdersModel> getAllOrders() {
		// TODO Auto-generated method stub
		return dao.selectOrders();
	}

}
