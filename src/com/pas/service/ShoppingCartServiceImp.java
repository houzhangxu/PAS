package com.pas.service;

import java.util.List;

import com.pas.model.ShoppingCartModel;

public interface ShoppingCartServiceImp {
  public boolean addGoods(ShoppingCartModel sc);
  public boolean removeGoods(int s_c_id);
}