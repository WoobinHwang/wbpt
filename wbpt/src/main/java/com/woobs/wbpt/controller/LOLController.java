package com.woobs.wbpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woobs.wbpt.entity.Champion;
import com.woobs.wbpt.repository.ChampionRepository;

import lombok.RequiredArgsConstructor;

//@RequestMapping
@Controller
@RequiredArgsConstructor
public class LOLController {

	@Autowired
	private final ChampionRepository championRepository;
	
	
	@GetMapping("/wbpt")
	public String BanPickToolPage(Model model) {
		// TODO Auto-generated method stub
		List<Champion> champions = championRepository.findAll();
//		System.out.println(champions.size());
		model.addAttribute("test", "abcde");
		model.addAttribute("champions", champions);
		
		return "BanPickToolPage";
	}
	
}
