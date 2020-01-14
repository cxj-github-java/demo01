package com.clive.service;

import java.util.List;

import com.clive.common.EchartsResult;
import com.clive.common.ZTreeNodeResult;

public interface TbItemCatService {
	//根据页面传来的id，查询商品分类信息
	List<ZTreeNodeResult> findTbItemCatById(Long parentId);

	List<EchartsResult> showEcharts();

}
