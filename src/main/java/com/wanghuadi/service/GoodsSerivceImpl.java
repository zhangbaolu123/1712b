package com.wanghuadi.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanghuadi.beans.Brand;
import com.wanghuadi.beans.Goods;
import com.wanghuadi.beans.GoodsKind;
import com.wanghuadi.mapper.GoodsMapper;

@Service
public class GoodsSerivceImpl implements GoodsSerivce {
	
	@Resource
	private GoodsMapper goodsMapper;

	public List<Goods> queryAll(Map<String, Object> map) {
		return goodsMapper.queryAll(map);
	}

	public List<Brand> queryBrand() {
		return goodsMapper.queryBrand();
	}

	public List<GoodsKind> queryKind() {
		return goodsMapper.queryKind();
	}

	public void addGoods(Goods goods) {
		goodsMapper.addGoods(goods);
	}

	public Goods queryGoodsById(Integer gid) {
		return goodsMapper.queryGoodsById(gid);
	}

	public void updateGoods(Goods goods) {
		goodsMapper.updateGoods(goods);
	}

	public void deleteGoods(String ids) {
		goodsMapper.deleteGoods(ids);
	}

}
