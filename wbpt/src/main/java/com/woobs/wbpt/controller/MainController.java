package com.woobs.wbpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woobs.wbpt.service.SeleniumService;

@Controller
public class MainController {

	@Autowired
	private SeleniumService seleniumService;
	
	@GetMapping("/")
	public String mainPage() {
		// TODO Auto-generated method stub
		
		return "MainPage";
	}
	
	
	@GetMapping("/selenium")
	@ResponseBody
	public String crawlling() {
		// TODO Auto-generated method stub
		seleniumService.scraping();
		
		return "end";
	}
	
	
}
