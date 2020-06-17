package com.webatoz.backend;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.Location;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebatozApplicationTests {
//    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "/Programming/anonymous/Spring//src/main/resources/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://wuhanvirus.kr/");
        ((ChromeDriver) driver).setLocation(new Location(30,40,30));
        Thread.sleep(5000);  // Let the user actually see something!
        WebElement a = ((ChromeDriver) driver).findElement(By.className("infected"));
        System.out.println(driver.getPageSource());
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("ChromeDriver");
//        searchBox.submit();
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

//    @Test
    public void jsoup() throws IOException {
        Map<String, Object> map = new HashMap<>();

        String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
        Document doc = null;

        doc = Jsoup.connect(url).get();
        Elements elements = doc.getElementsByClass("data_table").select("tbody").select("tr");
        // 지역명 가져오기
        elements.select("th").attr("scope", "row");
        // 확진자 사망자 가져오기
        elements.select("th").attr("headers", "s_type1").attr("class", "number");
        String str = "시도명 | 확진자(증감) | 사망자 \n";
        List<String> a = elements.eachText();
    }
}
