package com.pas.dao;

import java.util.List;

import com.pas.model.GoodsModel;
import com.pas.model.GoodsTypeModel;

public interface GoodsTpyeDaoImp {
	public GoodsTypeModel findGoodsTypeByGTId(int g_t_id);
	public List<GoodsTypeModel> selectGoodsTpye();
	public int getGTIdByName(String name);
	public void insertGoodsType(GoodsTypeModel gm);
	public int deleteGoodsTypeByGTId(int t_g_id);
	public int updateGoodsTypeByGTId(GoodsTypeModel gm);
	public List<GoodsTypeModel> getGTIdAndName();
}
