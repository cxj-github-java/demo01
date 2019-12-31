package com.clive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	//页面的controller，以/的话就跳首页
	
}
