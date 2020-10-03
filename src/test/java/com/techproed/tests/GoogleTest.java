package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends TestBaseFinal {
    // tests paketinin altinda GoogleTest diye bir class olusturacagiz.
    // aramaKutusuna techproeducation yazalim ve arama islemi yapalim.
    // Thread.sleep(3000)
    // tumlinklere bakalim ve bu testlerin icerisinde techproeducation.com adli websitesi var mi kontrol edelim.
    // varsa testimiz basarili, yoksa basarisiz olsun.

   @Test
    public void techproeducationAramaTesti() throws InterruptedException {
        // Rapor alma islemini baslatiyoruz
       extentTest = extentReports.createTest("Techproeducation Arama",
               "Google sonuclarinda techproeducation.com'u aradik.");
        // Bu sekilde her adima bilgi ekleyebiliriz
       extentTest.info("Google.com'a gidiyoruz.");
       Driver.getDriver().get(ConfigurationReader.getProperty("google_link"));

       extentTest.info("GooglePage class'indan nesne urettik.");
       GooglePage googlePage = new GooglePage();

       extentTest.info("techproeducation aramasi yapiyoruz");
       googlePage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("aranacak_kelime") + Keys.ENTER);

       Thread.sleep(3000);

       boolean testSonucu = false;
       for (WebElement w : googlePage.linkler){
           if (w.getText().contains("techproeducation.com")){
               testSonucu = true;
               break;
           }
       }
       extentTest.info("Assert islemi yapiyoruz");
       Assert.assertTrue(testSonucu);
       extentTest.info("Testimiz PASSED(basarili) !");


   }

    }