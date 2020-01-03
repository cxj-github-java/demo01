package com.clive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clive.bean.Json;
import com.clive.bean.TbItem;
import com.clive.service.TbItemService;

@Controller
@RequestMapping("/item")
public class TbItemController {
	@Autowired
	private TbItemService tbItemService;
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem findTbItemById(@PathVariable Long itemId){
		TbItem tbItem = tbItemService.findTbItemById(itemId);
		return tbItem;
	}
	@RequestMapping("/tbItem")
	@ResponseBody
	public Json findTbItemAll(Integer page,Integer limit){
		Integer i = tbItemService.findAllCount();
		List<TbItem> tbItem = tbItemService.findTbItemAll(page, limit);
		Json json = new Json();
		json.setCount(i);
		json.setCode(0);
		json.setMsg("");
		json.setData(tbItem);
		return json;
	}
}
