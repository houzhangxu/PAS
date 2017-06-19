package com.pas.service;

import java.util.List;

import com.pas.model.ShoppingCartModel;

public interface OrdersServiceImp {

	public boolean createOrder(int u_id,List<ShoppingCartModel> sc);
	
}
