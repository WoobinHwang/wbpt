package com.woobs.wbpt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woobs.wbpt.entity.Champion;
import com.woobs.wbpt.repository.ChampionRepository;
import com.woobs.wbpt.service.SeleniumService;

@SpringBootTest
class WbptApplicationTests {

	@Autowired
	private SeleniumService seleniumService;
	
	@Autowired
	private ChampionRepository championRepository;
	
	@Test
	void contextLoads() {
		System.out.println(123);
	}
	
	
	@Test
	void seleTest() {
		this.seleniumService.scraping();
		System.out.println("테스트 종료");
	}

	@Test
	void repoTest() {
		Champion champion = new Champion();
		
		champion.setChampNum(1);
		champion.setChampName("이름");
		champion.setChampNickname("별명");
		champion.setChampImage("이미지");
		
		championRepository.save(champion);
	}
	
	@Test
	void repoTest2() {
		System.out.println("테스트2");
		Champion champion = new Champion();
		champion = this.championRepository.findByChampName("아리s");
		
//		System.out.println(champion.getChampNickname());
		System.out.println(champion);
		
//		List<Champion> champs = this.championRepository.findAll();
//		System.out.println(champs.size());
		
	}
	
}
