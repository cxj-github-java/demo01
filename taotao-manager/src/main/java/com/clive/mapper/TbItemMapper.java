package com.clive.mapper;

import com.clive.bean.TbItem;

public interface TbItemMapper {
	//查询数据库tbitem表里，根据商品编号查询商品信息
	TbItem findTbItemById(Long tbItemId);

}
