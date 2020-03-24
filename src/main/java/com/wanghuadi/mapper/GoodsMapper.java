package com.wanghuadi.mapper;

import java.util.List;
import java.util.Map;

import com.wanghuadi.beans.Brand;
import com.wanghuadi.beans.Goods;
import com.wanghuadi.beans.GoodsKind;

public interface GoodsMapper {
	
	public List<Goods> queryAll(Map<String,Object> map);

	public List<Brand> queryBrand();

	public List<GoodsKind> queryKind();

	public void addGoods(Goods goods);

	public Goods queryGoodsById(Integer gid);

	public void updateGoods(Goods goods);

	public void deleteGoods(String ids);
	
}
