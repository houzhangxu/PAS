package com.pas.service;

import java.util.List;

import com.pas.model.GoodsModel;
import com.pas.model.GoodsTypeModel;

public interface GoodsServiceImp {
   public GoodsModel findGoods(int goods_id);
   public int addGoods(GoodsModel gm);
   public List<GoodsModel> getAllGoods();
   public int updateGoods(GoodsModel gm);
   public int deleteGoods(int g_id);
   
}
