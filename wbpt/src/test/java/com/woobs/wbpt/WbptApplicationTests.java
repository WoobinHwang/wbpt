package com.woobs.wbpt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.woobs.wbpt.service.SeleniumService;

@SpringBootTest
class WbptApplicationTests {

	@Autowired
	private SeleniumService seleniumService;
	
	@Test
	void contextLoads() {
		System.out.println(123);
	}
	
	
	@Test
	void seleTest() {
		this.seleniumService.scraping();
		System.out.println("테스트 종료");
	}

}
