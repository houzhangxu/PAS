package com.pas.dao;

import java.util.List;

import com.pas.model.GoodsModel;

public interface GoodsDaoImp {
	public GoodsModel findGoodsByGId(int g_id);
	public List<GoodsModel> selectGoods();
	public int getGIdByGoodsName(String goods_name);
	public void insertGoods(GoodsModel gm);
	public int deleteGoodsGId(int g_id);
	public int updateGoodsGId(GoodsModel gm);
	public List<GoodsModel> getGoodsNameByGoodsType(String goods_type);
	public List<GoodsModel> getAllGoodsName();
	public List<GoodsModel> selectGoodsByGoodsName(String goods_name);
	public int getCount();
}
