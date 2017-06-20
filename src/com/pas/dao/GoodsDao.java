package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.GoodsModel;

public class GoodsDao implements GoodsDaoImp {
	@Autowired
	private SqlSession ss;

	@Override
	public GoodsModel findGoodsByGId(int g_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("goods.findGoodsByGId", g_id);
	}

	@Override
	public List<GoodsModel> selectGoods() {
		// TODO Auto-generated method stub
		List<GoodsModel> list=ss.selectList("goods.selectGoods");
		return list;
	}

	@Override
	public int getGIdByGoodsName(String goods_name) {
		// TODO Auto-generated method stub
		return ss.selectOne("goods.getGIdByGoodsName", goods_name);
	}

	@Override
	public void insertGoods(GoodsModel gm) {
		// TODO Auto-generated method stub
		ss.insert("goods.insertGoods", gm);
	}

	@Override
	public int deleteGoodsGId(int g_id) {
		// TODO Auto-generated method stub
		return ss.update("goods.deleteGoodsGId", g_id);
	}

	@Override
	public int updateGoodsGId(GoodsModel gm) {
		// TODO Auto-generated method stub
		return ss.update("goods.updateGoodsGId", gm);
	}

	@Override
	public List<GoodsModel> getGoodsNameByGoodsType(int goods_type) {
		// TODO Auto-generated method stub
		List<GoodsModel> list=ss.selectList("goods.getGoodsNameByGoodsType", goods_type);
		return list;
	}

}
