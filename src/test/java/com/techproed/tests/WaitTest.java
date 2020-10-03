package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest extends TestBase {

    @Test
    public void implicitlyWaitTest(){
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // implicitly wait:Sayfadaki findelement islemi gerceklesirken, belirledigimiz maximum sureye kadar
        //bekliyor.Oncesinde bulursa, bekleme islemini birakip devam ediyor.
        //Ornek: Eger 2. saniyede aranilan webelementi bulursa, 8 saniye daha BEKLEMIYOR. Direk alt satira geciyor

        driver.get("http://Google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        //Thread sleep verilen sure kadar bekler

    }
    @Test
    public void explicitWaitTest(){
        // WebDriverWait class'indan nesne uretmek zorundayiz !
        // implicitlyWait'ten en onemli farki, burada herhangi bir webelment icin
        // ozel bir bekleme islemi gerceklestiriyoruz. (SARTLI BEKLEME)

        // Explicit Wait icin de en onemli fark, burada bir kosul belirtiyoruz.
        // Ornek : Aradigimiz WebElement tiklayabiliyor olsun.
        // Ornek : Aradigimiz Webelement'in yazisi "deneme' olsun.

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        //<button autocomplete="off" type="button" onclick="swapCheckbox()">Remove</button>
        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        removeButton.click();

        //<p id="message">It's gone!</p>
        //WebElement message = driver.findElement(By.id("message"));

        WebDriverWait wait = new WebDriverWait(driver , 30);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message.getText());

    }
}
