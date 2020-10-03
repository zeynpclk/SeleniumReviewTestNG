package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends TestBase {

    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://fhctrip-qa.com/admin/HotelroomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }

    @Test
    public void basliklar(){
        // sayfadaki basliklar : //thead//th

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead//th"));
        for (WebElement w : basliklar){
            System.out.println(w.getText());
        }

    }
    @Test
    public void tumsatirlar(){
        // sayfadaki tum satirlar : //tbody/tr
        List<WebElement> satirlar = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement w : satirlar){
            System.out.println(w.getText());
        }
    }

    @Test
    public void sutunYazdirma(){
        // 5. sutun : //tbody/tr/td[5]
        List<WebElement> besinciSutun = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement w : besinciSutun){
            System.out.println(w.getText());
        }
    }

    @Test
    public void hucreYazdirma(){
        // 2. satir 5. sutun gibi istedigimiz hucreyi yazdirma ://tbody/tr[2]/td[5]
        WebElement hucre = driver.findElement(By.xpath("//tbody/tr[2]/td[5]"));
        System.out.println(hucre.getText());
    }

    @AfterMethod
    public void afterMethod(){

    }
}
