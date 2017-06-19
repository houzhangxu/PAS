package com.pas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.ShoppingCartModel;

public class ShoppingCartService implements ShoppingCartServiceImp {

	@Autowired
	private ShoppingCartDaoImp dao;
	
	@Override
	public boolean addGoods(ShoppingCartModel sc) {
		
		if(dap.insertShoppingCart(sc)>0){
			return true;
		}
		
		return false;
	}


	@Override
	public boolean removeGoods(int s_c_id) {
		
		if(dao.deleteShoppingCartBySCId(s_c_id)>0){
			return true;
		}
		
		return false;
	}

}
