package com.pas.dao;

import java.util.List;

import com.pas.model.ShoppingCartModel;

public interface ShoppingCartDaoImp {
	public ShoppingCartModel findShoppingCartBySCId(int s_c_id);
	public List<ShoppingCartModel> selectShoppingCart();
	public void insertShoppingCart(ShoppingCartModel scm);
	public int deleteShoppingCartBySCId(int s_c_id);
	public int updateShoppingCartBySCId(ShoppingCartModel scm);
	public List<ShoppingCartModel> selectShoppingCartByUId(int u_id);
	public int getSCID(ShoppingCartModel scm);
	public int addTotalBySCId(int s_c_id);
	public int subTotalBySCId(int s_c_id);
}
