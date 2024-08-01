package selenium_practic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest3 {

	public static void main(String[] args) {
		// 1. 크롬 드라이버를 사용할 준비를 한다.
		// 자바와 크롬을 연동하기 위한 준비
		WebDriver driver = new ChromeDriver();		
		driver.get("https://finance.naver.com/news/");
//		String mainPage = driver.getWindowHandle();
//		driver.switchTo().window(mainPage);

		// 뉴스가져오기
		List<WebElement> newsTitleList = driver
				.findElements(By.cssSelector(".main_news > ul a"));
//
		for (WebElement webElement : newsTitleList) {
			System.out.println(webElement.getText());
		} // 데이터 크롤링
	}

}








