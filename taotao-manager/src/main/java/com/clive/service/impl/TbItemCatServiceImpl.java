package com.clive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clive.bean.TbitemCat;
import com.clive.common.ZTreeNodeResult;
import com.clive.mapper.TbItemCatMapper;
import com.clive.service.TbItemCatService;
@Service
public class TbItemCatServiceImpl implements TbItemCatService {
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
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

}
