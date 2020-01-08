package com.clive.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.clive.bean.TbItem;
import com.clive.common.LayuiTableResult;
import com.clive.common.TaotaoResult;
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
	@RequestMapping("/showtbItem")
	@ResponseBody
	public LayuiTableResult findTbItemByPage(Integer page,Integer limit){
		LayuiTableResult result = tbItemService.findTbItemByPage(page, limit);
		return result;
	}
	@RequestMapping("/itemDelete")
	@ResponseBody
	public TaotaoResult deleteItemById(@RequestBody List<TbItem> items){
		TaotaoResult updateItemById = tbItemService.updateItem(items,2);
		return updateItemById;
	}
	@RequestMapping("/upItem")
	@ResponseBody
	public TaotaoResult upItem(@RequestBody List<TbItem> items){
		TaotaoResult upItem = tbItemService.updateItem(items,1);
		return upItem;
	}
	@RequestMapping("/downItem")
	@ResponseBody
	public TaotaoResult downItem(@RequestBody List<TbItem> items){
		TaotaoResult upItem = tbItemService.updateItem(items,0);
		return upItem;
	}
	@RequestMapping("/searchtbItem")
	@ResponseBody
	public LayuiTableResult searchTbItem(String title,Long price,String sellPoint,Integer page,Integer limit) throws Exception{
		byte[] bytes = title.getBytes("iso-8859-1");
		title = new String(bytes,"utf-8");
		byte[] bytess = sellPoint.getBytes("iso-8859-1");
		sellPoint = new String(bytess,"utf-8");
		LayuiTableResult searchTbItem = tbItemService.searchTbItem(title,price,sellPoint,page, limit);
		return searchTbItem;
	}
}
