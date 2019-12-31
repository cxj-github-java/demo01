package com.clive.service;

import com.clive.bean.TbItem;

public interface TbItemService {
	//根据编号查询指定信息
	TbItem findTbItemById(Long tbItemId);
}
