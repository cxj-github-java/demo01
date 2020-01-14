package com.clive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.TbItem;
import com.clive.bean.TbitemCat;
import com.clive.common.EchartsResult;
import com.clive.common.ZTreeNodeResult;
import com.clive.mapper.TbItemCatMapper;
import com.clive.mapper.TbItemMapper;
import com.clive.service.TbItemCatService;
@Service
public class TbItemCatServiceImpl implements TbItemCatService {
	private String name;
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Autowired
	private TbItemMapper tbItemMapper; 
	@Override
	public List<ZTreeNodeResult> findTbItemCatById(Long parentId) {
		List<TbitemCat> tbItemCats = tbItemCatMapper.findTbItemCatById(parentId);
		List<ZTreeNodeResult> result = new ArrayList<ZTreeNodeResult>();
		for (TbitemCat tbitemCat : tbItemCats) {
			ZTreeNodeResult node = new ZTreeNodeResult();
			node.setId(tbitemCat.getId());
			node.setName(tbitemCat.getName());
			node.setIsParent(tbitemCat.getIsParent());
			result.add(node);
		}
		return result;
	}

	@Override
	public List<EchartsResult> showEcharts() {
		List<EchartsResult> results = new ArrayList<EchartsResult>();
		List<TbItem> tbItems = tbItemMapper.showEchartsByCId();
		for (TbItem tbItem : tbItems) {
			EchartsResult result = new EchartsResult();
			TbitemCat tbitemCat = tbItemCatMapper.getTbItemCatById(tbItem.getcId());
			getFirstItemCat(tbitemCat);
			result.setName(name+"类");
			result.setName(tbitemCat.getName());
			int i = tbItemMapper.findTbItemByCIdCount(tbItem.getcId());
			result.setValue(i);
			results.add(result);
		}
		return results;
	}
	private String getFirstItemCat(TbitemCat tbItemCat) {
		TbitemCat cat = tbItemCatMapper.getTbItemCatById(tbItemCat.getParentId());
		if(cat!=null){
			name = cat.getName();
			getFirstItemCat(cat);
		}
		return null;
	}
}
