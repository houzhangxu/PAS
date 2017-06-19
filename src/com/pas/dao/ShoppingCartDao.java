package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.ShoppingCartModel;

public class ShoppingCartDao implements ShoppingCartDaoImp {
	@Autowired
	private SqlSession ss;

	@Override
	public ShoppingCartModel findShoppingCartBySCId(int s_c_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("shopping_cart.findShoppingCartBySCId", s_c_id);
	}

	@Override
	public List<ShoppingCartModel> selectShoppingCart() {
		// TODO Auto-generated method stub
		List<ShoppingCartModel> list=ss.selectList("shopping_cart.selectShoppingCart");
		return list;
	}

	@Override
	public void insertShoppingCart(ShoppingCartModel scm) {
		// TODO Auto-generated method stub
		ss.insert("shopping_cart.insertShoppingCart", scm);
	}

	@Override
	public void deleteShoppingCartBySCId(int s_c_id) {
		// TODO Auto-generated method stub
		ss.delete("shopping_cart.deleteShoppingCartBySCId", s_c_id);
	}

	@Override
	public void updateShoppingCartBySCId(ShoppingCartModel scm) {
		// TODO Auto-generated method stub
		ss.update("shopping_cart.updateShoppingCartBySCId", scm);
	}

}
