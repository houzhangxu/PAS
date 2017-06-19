package com.pas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.OrderGoodsModel;
import com.pas.model.ShoppingCartModel;

public class OrdersService implements OrdersServiceImp {

	@Autowired
	private ShoppingCartDaoImp dao;

	@Override
	public boolean createOrder(int u_id, List<ShoppingCartModel> sc) {
		
		List<OrderGoodsModel> itemsList = new ArrayList<OrderGoodsModel>();
		OrderGoodsModel items_1 = new OrderGoodsModel();
		
		for(int i;i<sc.size();i++){

			
		}
		
		return false;
	}
	

}
