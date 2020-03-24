package com.wanghuadi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanghuadi.beans.Brand;
import com.wanghuadi.beans.Goods;
import com.wanghuadi.beans.GoodsKind;
import com.wanghuadi.service.GoodsSerivce;
import com.wanghuadi.utils.FileUtils;

@Controller
public class GoodsController {
	
	@Resource
	private GoodsSerivce goodsSerivce;
	
	/**
	 * 商品列表展示
	 * @param model
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("list")
	public String queryAll(Model model,@RequestParam(defaultValue="1")Integer pageNum){
		Map<String, Object> map = new HashMap<String, Object>();
		//分页
		PageHelper.startPage(pageNum, 3);
		List<Goods> list = goodsSerivce.queryAll(map );
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		model.addAttribute("page",page);
		return "list";
	}

	@RequestMapping("toadd")
	public String toadd(Model model){
		List<Brand> brandList = goodsSerivce.queryBrand();
		List<GoodsKind> kindList = goodsSerivce.queryKind();
		
		model.addAttribute("brandList", brandList);
		model.addAttribute("kindList", kindList);
		
		return "add";
	}
	
	@RequestMapping("add")
	public String add(Goods goods,MultipartFile file) throws IllegalStateException, IOException{
		try {
			String upload = FileUtils.upload(file);
			goods.setPriurl(upload);
			//添加
			goodsSerivce.addGoods(goods);
			return "redirect:list";
		} catch (Exception e) {
			return "add";
		}
	}
		
	@RequestMapping("lookImg")
	public void lookImg(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
	
	
	@RequestMapping("toupdate")
	public String toupdate(Integer gid,Model model){
		Goods goods = goodsSerivce.queryGoodsById(gid);
		model.addAttribute("goods", goods);
		List<Brand> brandList = goodsSerivce.queryBrand();
		List<GoodsKind> kindList = goodsSerivce.queryKind();
		model.addAttribute("brandList", brandList);
		model.addAttribute("kindList", kindList);
		return "update";
	}
	
	@RequestMapping("update")
	public String update(Goods goods,MultipartFile file) throws IllegalStateException, IOException{
		try {
			String upload = FileUtils.upload(file);
			goods.setPriurl(upload);
			//修改
			goodsSerivce.updateGoods(goods);
			return "redirect:list";
		} catch (Exception e) {
			return "update";
		}
	}
	
	@RequestMapping("deleteGoods")
	@ResponseBody
	public boolean deleteGoods(String ids){
		try {
			goodsSerivce.deleteGoods(ids);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
