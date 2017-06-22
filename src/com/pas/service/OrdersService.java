package com.pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.OrdersDaoImp;
import com.pas.model.ShoppingCartModel;

public class OrdersService implements OrdersServiceImp {

	@Autowired
	private OrdersDaoImp dao;
	
	@Override
	public boolean createOrder(int u_id, List<ShoppingCartModel> sc) {
		
		return false;
	}

	@Override
	public boolean addGoods(ShoppingCartModel sc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}

}
