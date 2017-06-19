package com.pas.dao;

import java.util.List;

import com.pas.model.GoodsModel;

public interface GoodsDaoImp {
	public GoodsModel findGoodsByGId(int g_id);
	public List<GoodsModel> selectGoods();
	public int getGIdByGoodsName(String goods_name);
	public void insertGoods(GoodsModel gm);
	public void deleteGoodsGId(int g_id);
	public void updateGoodsGId(GoodsModel gm);
	public List<GoodsModel> getGoodsNameByGoodsType(int goods_type);
}
