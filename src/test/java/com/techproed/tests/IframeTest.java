package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    // 1. Adim : Sayfadaki iframe'yi bulacagiz
    // 2. adim : O iframe'in icerisindeki "p" tag name'ine sahip webelementi bulacagiz.
    // 3. adim : Icerisine "Selamlar iframe" yazdiracagiz
    // 4. adim : iframe'den cikis yapip, sayfamiza donecegiz(defaultContent)
    // 5. adim : "Elemental selenium" lim=nkini bulup, tiklayacagiz.

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/iframe");

        /*
          <iframe id="mce_0_ifr" src="javascript:&quot;&quot;" frameborder="0" allowtransparency="true"
          title="Rich Text Area.
          Press ALT-F9 for menu. Press ALT-F10 for toolbar.
          Press ALT-0 for help" style="width: 100%; height: 100px; display: block;"></iframe>


         */

        // iframe'e gecis yapmak icin 1. yontem index ile
        // driver.switchTo().frame(0);

        // 2. yontem id attribute degeri kullanarak
        //driver.switchTo().frame("mce_0_ifr");

        // 3. yontem webelement ile

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement yaziBolumu = driver.findElement(By.tagName("p"));
        yaziBolumu.clear();
        yaziBolumu.sendKeys("Selamlar IFRAME");
        driver.switchTo().defaultContent();

        //<a target="_blank" href="http://elementalselenium.com/">Elemental Selenium</a>
        // tagName, linkText, partialLinkText, xpath, cssSelector
        WebElement link = driver.findElement(By.partialLinkText("Elemental Selenium"));
        link.click();

        }
}

