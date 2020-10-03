package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadUploadTest extends TestBase {
    WebDriver driver;
    @Test
    public void dosyaVarMi() {
        // Şuanda bulunduğumuz klasörün dosya yolunu veriyor.(String olarak)
        System.out.println(System.getProperty("user.dir"));
        // Kullanıcın ana klasörünün dosya yolunu veriyor. (String olarak)
        System.out.println(System.getProperty("user.home"));
        // Java ile belirtilen adreste, aradığımız dosyanın var olup olmadığını
        // aşağıdaki kod ile yapabiliyoruz.
        // Eğer dosya varsa, TRUE  - Eğer dosya yoksa, FALSE
        // C:\Users\isimsiz\IdeaProjects\SeleniumReviewTestNG\pom.xml
        boolean varMi = Files.exists(Paths.get("C:\\Users\\User\\IdeaProjects\\SeleniumReviewTestNG\\pom.xml"));
        Assert.assertTrue(varMi);
    }

    @Test
    public void dosyaIndirme() {
        // websitesinden, indirmek istediğimiz dosyayı indirdikten sonra,
// bilgisayarımızda indirme klasöründe, o dosyanın var olup olmadığını kontrol
// ediyoruz. Eğer dosya varsa, indirme işleminde bir problem yok diyebiliriz.
// Dikkat edilmesi gereken bir husus : Bazen indirme işlemi uzun sürebilir. Bu yüzden
// indirme işleminden sonra, bir müddet beklemek gerekir. Thread.sleep ile yapabiliriz.
        driver.get("http://the-internet.herokuapp.com/download");
        // indirme islemi basliyor
        WebElement penguenLink = driver.findElement(By.partialLinkText("penguins.jpg"));
        penguenLink.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        // C:\Users\isimsiz\Downloads\Penguins.jpg
        // DOSYA VARSA - TRUE       DOSYA YOKSA - FALSE
        boolean varMi = Files.exists(Paths.get("C:Users//User//Downloads//Penguins.jpg"));
        Assert.assertTrue(varMi);

    }
    @Test
    public void dosyaUpload(){
        driver.get("http://the-internet.herokuapp.com/upload");

        // "dosya sec (choose file)" webelementini locate ettik.
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        // sendkeys ile upload etmek istedigimiz dosyanin adresini gondermemiz gerekiyor.
        chooseFile.sendKeys("C:\\Users\\User\\Downloads\\logo5.png");

        driver.findElement(By.id("file- submit")).click();

    }



}