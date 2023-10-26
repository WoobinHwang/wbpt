package com.woobs.wbpt.service;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import com.woobs.wbpt.entity.Champion;
import com.woobs.wbpt.repository.ChampionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeleniumServiceImpl implements SeleniumService {

	private WebDriver driver;
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "D:/woobin/Installer/chromedriver-win64/chromedriver.exe";
	private String base_url;
	private final ChampionRepository championRepository;
	
	// setProperty 메소드를 통해 프로그램명과 경로 받기
	// selenium으로 db 저장까지
    public void scraping() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        base_url = "https://game.naver.com/lounge/League_of_Legends/db/champion";
        driver.get(base_url);

        try {
//        	3초간 쉬기
            Thread.sleep(3000);

//          더보기 버튼 클릭
            while (true) {
            	try {
            		WebElement moreButton = driver.findElement(By.ByClassName.className("gamedb_icon__1jSHy"));
            		moreButton.click();
            		Thread.sleep(1000);
            		System.out.println("continue");
				} catch (Exception e) {
					// TODO: 더보기 버튼이 없을때
					System.out.println("더보기 못찾음 // while 종료");
					break;
				}
			}
            
            // 챔피언 정보 리스트
            List<WebElement> championNames = driver.findElements(By.className("card_content-header__title__oJkdR"));
            List<WebElement> championImages = driver.findElements(By.className("card_thumbnail__image__2xUgG"));
            List<WebElement> championNicknames = driver.findElements(By.className("card_content-header__label__2OVCE"));
            // 챔피언 역할과 출신지
//            List<WebElement> championDetailes = driver.findElements(By.className("card_content-body__1l5Pf"));
            
            System.out.println(championNames.size());
            System.out.println(championImages.size());
            System.out.println(championNicknames.size());
//            System.out.println(championDetailes.size());
            
            for (int i = championNames.size()-1; i >= 0; i--) {
            	System.out.println(i);
            	System.out.println(championNames.get(i).getText());
//            	System.out.println(championImages.get(i).getAttribute("src"));
//            	System.out.println(championNicknames.get(i).getText());
//            	System.out.println(championDetailes.get(i).getText());
            
            	if (this.championRepository.findByChampName(
            			championNames.get(i).getText()) == null) {
					Champion champion = new Champion();
					champion.setChampName(championNames.get(i).getText());
					champion.setChampNickname(championNicknames.get(i).getText());
					champion.setChampImage(championImages.get(i).getAttribute("src"));
					this.championRepository.save(champion);
				} else {
					System.out.println("이미 있음");
					break;
				}

			}
            
            System.out.println("함수 본문 끝");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	System.out.println("셀레니움 종료");
            driver.quit();
        }
    }
	
	
}
