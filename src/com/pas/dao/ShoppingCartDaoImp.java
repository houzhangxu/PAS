package com.pas.dao;

import java.util.List;

import com.pas.model.ShoppingCartModel;

public interface ShoppingCartDaoImp {
	public ShoppingCartModel findShoppingCartBySCId(int s_c_id);
	public List<ShoppingCartModel> selectShoppingCart();
	public void insertShoppingCart(ShoppingCartModel scm);
	public void deleteShoppingCartBySCId(int s_c_id);
	public void updateShoppingCartBySCId(ShoppingCartModel scm);
}
