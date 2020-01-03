package com.clive.service;

import java.util.List;

import com.clive.bean.TbItem;

public interface TbItemService {
	//查询所有商品信息
	List<TbItem> findTbItemAll(Integer page,Integer limit);
	//根据编号查询指定信息
	TbItem findTbItemById(Long tbItemId);
	Integer findAllCount();
	
	
}
