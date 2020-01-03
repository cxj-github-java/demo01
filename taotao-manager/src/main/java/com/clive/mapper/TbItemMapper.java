package com.clive.mapper;

import java.util.List;

import com.clive.bean.TbItem;

public interface TbItemMapper {
	//查询数据库tbitem表里，根据商品编号查询商品信息
	TbItem findTbItemById(Long tbItemId);
	//查询所有商品信息
	
	List<TbItem> findTbItemAll(Integer page, Integer limit);

	Integer findAllCount();

}
