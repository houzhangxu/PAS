package com.pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pas.dao.GoodsDaoImp;
import com.pas.model.GoodsModel;

public class GoodsService implements GoodsServiceImp {

	@Autowired
	private GoodsDaoImp dao;
	
	@Override
	public GoodsModel findGoods(int goods_id) {
		
		return dao.findGoodsByGId(goods_id);
	}

	@Override
	public int addGoods(GoodsModel gm) {
		// TODO Auto-generated method stub
		dao.insertGoods(gm);
		return gm.getG_id();
	}

	@Override
	public List<GoodsModel> getAllGoods() {
		// TODO Auto-generated method stub
		return dao.selectGoods();
	}

	@Override
	public int updateGoods(GoodsModel gm) {
		// TODO Auto-generated method stub
		
		return dao.updateGoodsGId(gm);
	}

	@Override
	public int deleteGoods(int g_id) {
		// TODO Auto-generated method stub
		return dao.deleteGoodsGId(g_id);
	}

	@Override
	public List<GoodsModel> getGoodsByName(String goods_name) {
		// TODO Auto-generated method stub
		return dao.selectGoodsByGoodsName(goods_name);
	}

	@Override
	public List<GoodsModel> getAllGoodsName() {
		// TODO Auto-generated method stub
		return dao.getAllGoodsName();
	}

	@Override
	public List<GoodsModel> getGoodsNameByType(String goods_type) {
		// TODO Auto-generated method stub
		return dao.getGoodsNameByGoodsType(goods_type);
	}
	
	
	

}
