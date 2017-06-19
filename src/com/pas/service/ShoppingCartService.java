package com.pas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.ShoppingCartDaoImp;
import com.pas.model.ShoppingCartModel;

public class ShoppingCartService implements ShoppingCartServiceImp {

	@Autowired
	private ShoppingCartDaoImp dao;
	
	@Override
	public boolean addGoods(ShoppingCartModel sc) {
		
		dao.insertShoppingCart(sc);
		
		if(sc.getU_id()!=0)return true;
		
		return false;
	}

	@Override
	public boolean removeGoods(int s_c_id) {
		
		try{
			dao.deleteShoppingCartBySCId(s_c_id);
		}catch(Exception e){
			return true;
		}
		
		
		return false;
	}

}
