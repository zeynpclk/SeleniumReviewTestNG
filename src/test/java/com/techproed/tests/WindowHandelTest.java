package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandelTest extends TestBase {
    @Test
    public void test(){
      driver.get("https://the-internet.herokuapp.com/windows");

      /*
      1.Adim ; the-internet.herokuapp.com/windows adresine gittikten sonra
      sayfanin window handle'ini alalim
      2.Adim : click here linkine tiklayalim
      3.Adim : Gittigimiz sayfadan, the-internet.herokuapp.com/windows sayfasina window handle'ini
      kullanarak gecis yapalim
       */

       String anaSayfaWindowHandle = driver.getWindowHandle();
        System.out.println(anaSayfaWindowHandle);

        //<a href="/windows/new" ,="" target="_blank">Click Here</a>
        // tagName, xpath, cssSelector, linkText, partiallinkText

       // WebElement clikHereLinki = driver.findElement(By.partialLinkText("Click Here"));
       // clikHereLinki.click();// Boyle kullanabiliriz
        driver.findElement(By.partialLinkText("Click Here")).click(); //Daha kisa boyle de yazabiliriz

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //window handle kullanarak istedigimiz pencereye su sekilde gecis yapabiliyoruz
        driver.switchTo().window(anaSayfaWindowHandle);

        //Acik olan tum pencerelerin window handle'larini almak

        String ikinciSayfaWindowHandle = "";
        Set<String> tumWindowHandlelar = driver.getWindowHandles();
        // anaSayfaWindowhandle =CDwindow-3938F8ED15E1864E745C93C6C914C72A
        //iknciSayfaWindowHandle = CDwindow-49D4028B086A62CD658D136BACCD3391
        for (String handle : tumWindowHandlelar){
            if (!handle.equals(anaSayfaWindowHandle)){
              ikinciSayfaWindowHandle = handle;
            }

            System.out.println(handle);

        }
        driver.switchTo().window(ikinciSayfaWindowHandle);

        //Set<String> i Array'e cevirme
        Object[]windowHandleDegerleri = tumWindowHandlelar.toArray();
        System.out.println(windowHandleDegerleri[0].toString());
        System.out.println(windowHandleDegerleri[1].toString());
    }

}
