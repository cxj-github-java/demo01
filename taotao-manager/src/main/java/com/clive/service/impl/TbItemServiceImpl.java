package com.clive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.TbItem;
import com.clive.mapper.TbItemMapper;
import com.clive.service.TbItemService;
@Service
public class TbItemServiceImpl implements TbItemService {
	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem findTbItemById(Long tbItemId) {
		TbItem tbItem = tbItemMapper.findTbItemById(tbItemId);
		return tbItem;
	}

	@Override
	public List<TbItem> findTbItemAll(Integer page, Integer limit) {
		List<TbItem> tbItem = tbItemMapper.findTbItemAll(page,limit);
		return tbItem;
	}

	@Override
	public Integer findAllCount() {
		Integer i = tbItemMapper.findAllCount();
		return i;
	}

	

	
}
