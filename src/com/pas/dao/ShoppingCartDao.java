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
	public int deleteShoppingCartBySCId(int s_c_id) {
		// TODO Auto-generated method stub
		return ss.delete("shopping_cart.deleteShoppingCartBySCId", s_c_id);
	}

	@Override
	public int updateShoppingCartBySCId(ShoppingCartModel scm) {
		// TODO Auto-generated method stub
		return ss.update("shopping_cart.updateShoppingCartBySCId", scm);
	}

	@Override
	public List<ShoppingCartModel> selectShoppingCartByUId(int u_id) {
		// TODO Auto-generated method stub
		return ss.selectList("shopping_cart.selectShoppingCartByUId",u_id);
	}

	@Override
	public int getSCID(ShoppingCartModel scm) {
		// TODO Auto-generated method stub
		Integer i =  ss.selectOne("shopping_cart.getSCID",scm);
		if(i == null){
			return 0;
		}
		return i.intValue();
	}

	@Override
	public int addTotalBySCId(int s_c_id) {
		// TODO Auto-generated method stub
		return ss.update("shopping_cart.addTotalBySCId", s_c_id);
	}

	@Override
	public int subTotalBySCId(int s_c_id) {
		// TODO Auto-generated method stub
		return ss.update("shopping_cart.subTotalBySCId", s_c_id);
	}

}
