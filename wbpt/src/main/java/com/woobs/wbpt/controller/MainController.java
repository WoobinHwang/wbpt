package com.woobs.wbpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/")
	@ResponseBody
	public String mainPage() {
		// TODO Auto-generated method stub
		return "aaa";
	}
	
}
