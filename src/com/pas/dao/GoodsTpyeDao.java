package com.pas.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pas.model.GoodsTypeModel;

public class GoodsTpyeDao implements GoodsTpyeDaoImp {
	@Autowired
	private SqlSession ss;

	@Override
	public GoodsTypeModel findGoodsTypeByGTId(int g_t_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("goods_type.findGoodsTypeByGTId", g_t_id);
	}

	@Override
	public List<GoodsTypeModel> selectGoodsTpye() {
		// TODO Auto-generated method stub
		List<GoodsTypeModel> list=ss.selectList("goods_type.selectGoodsTpye");
		return list;
	}

	@Override
	public int getGTIdByName(String name) {
		// TODO Auto-generated method stub
		return ss.selectOne("goods_type.getGTIdByName", name);
	}

	@Override
	public void insertGoodsType(GoodsTypeModel gm) {
		// TODO Auto-generated method stub
		ss.insert("goods_type.insertGoodsType", gm);
	}

	@Override
	public int deleteGoodsTypeByGTId(int t_g_id) {
		// TODO Auto-generated method stub
		return ss.delete("goods_type.deleteGoodsTypeByGTId", t_g_id);
	}

	@Override
	public int updateGoodsTypeByGTId(GoodsTypeModel gm) {
		// TODO Auto-generated method stub
		return ss.update("goods_type.updateGoodsTypeByGTId", gm);
	}

	@Override
	public List<GoodsTypeModel> getGTIdAndName() {
		// TODO Auto-generated method stub
		List<GoodsTypeModel> list=ss.selectList("goods_type.getGTIdAndName");
		return list;
	}

}
