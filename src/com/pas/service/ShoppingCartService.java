package com.pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.ShoppingCartDaoImp;
import com.pas.model.ShoppingCartModel;

public class ShoppingCartService implements ShoppingCartServiceImp {

	@Autowired
	private ShoppingCartDaoImp dao;
	
	@Override
	public boolean addGoods(ShoppingCartModel sc) {
		
		dao.insertShoppingCart(sc);
		
		if(sc.getS_c_id() > 0)return true;
		
		return false;
	}

	@Override
	public boolean removeGoods(int s_c_id) {
		
		try{
			dao.deleteShoppingCartBySCId(s_c_id);
		}catch(Exception e){
			return false;
		}
		
		
		return true;
	}

	@Override
	public List<ShoppingCartModel> selectCartInfoByUId(int u_id) {
		// TODO Auto-generated method stub
		return dao.selectShoppingCartByUId(u_id);
	}

	@Override
	public int getSCID(ShoppingCartModel scm) {
		// TODO Auto-generated method stub
		return dao.getSCID(scm);
	}

	@Override
	public int addTotal(int s_c_id) {
		// TODO Auto-generated method stub
		return dao.addTotalBySCId(s_c_id);
	}

	@Override
	public int subTotal(int s_c_id) {
		// TODO Auto-generated method stub
		return dao.subTotalBySCId(s_c_id);
	}

}
