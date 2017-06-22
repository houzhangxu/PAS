package com.pas.service;

import java.util.List;

import com.pas.model.ShoppingCartModel;

public interface ShoppingCartServiceImp {
  public boolean addGoods(ShoppingCartModel sc);
  public boolean removeGoods(int s_c_id);
  public List<ShoppingCartModel> selectCartInfoByUId(int u_id);
  public int getSCID(ShoppingCartModel scm);
  public int addTotal(int s_c_id);
  public int subTotal(int s_c_id);
}
