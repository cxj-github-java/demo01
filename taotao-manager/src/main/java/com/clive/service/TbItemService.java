package com.clive.service;

import java.util.List;

import com.clive.bean.TbItem;
import com.clive.common.LayuiTableResult;
import com.clive.common.TaotaoResult;

public interface TbItemService {
	
	//根据编号查询指定信息
	TbItem findTbItemById(Long tbItemId);
	/**
	 * 分页显示商品信息
	 * @param page 当前页，需要计算索引
	 * @param limit 每一页显示的条数
	 * @return layui指定的json格式
	 */
	LayuiTableResult findTbItemByPage(Integer page,Integer limit);
	/**
	 * 
	 * @param items 需要删除的商品集合对象，
	 * @return
	TaotaoResult deleteItemById(List<TbItem > items);
	 */
	/**
	 * 上架下架和删除状态
	 * @param items 需要上架和下架的商品对象，id
	 * @param type 1代表上架，0代表下架 ,2代表删除
	 * @return
	 * 返回TaotaoResult对象，里面有三个属性status，msg，data
	 * saatus:代表响应的状态，200--成功
	 * msg;代表提示的页面信息
	 * data：如果页面需要json格式的数据的话，data内就是这个对象
	 */
	TaotaoResult updateItem(List<TbItem> items, Integer type);
	/**
	 * 搜索商品信息
	 * @param tbItem
	 * @return
	 */
	
	LayuiTableResult searchTbItem(String title, Long price, String sellPoint, Integer page, Integer limit);
	
	
}
