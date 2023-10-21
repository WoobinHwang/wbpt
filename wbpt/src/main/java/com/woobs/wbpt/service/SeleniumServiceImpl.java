package com.woobs.wbpt.service;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
public class SeleniumServiceImpl implements SeleniumService {

	private WebDriver driver;
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "D:/woobin/Installer/chromedriver-win64/chromedriver.exe";
	private String base_url;
	
	//setProperty 메소드를 통해 프로그램명과 경로 받기
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
            
            List<WebElement> championNames = driver.findElements(By.className("card_content-header__title__oJkdR"));
            int number = 0; 
            
            for(WebElement championName : championNames) {
            	System.out.println(championName.getText());
            	System.out.println(number);
            	number++;
            }
            
            System.out.println("함수 본문 끝");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	System.out.println("셀레니움 종료");
//            driver.quit();
        }
    }
	
	
}
