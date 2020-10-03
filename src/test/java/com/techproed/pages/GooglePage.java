package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePage {
    /*1. Örnek : Google Arama
	- pages paketinin altında GooglePage adlı class oluşturalım.
	- aramaKutusu webelementini bulalım. (@FindBy)
	- tumLinkler List<WebElement>, sonuç sayfasındaki tüm linkleri liste şeklinde bulalım.
	- aramaKutusu 'a techproeducation yazalım ve arama işlemi yapalım.
	- tumLinkler 'e bakalım ve bu testlerin içerisinde techproeducation.com adlı websitesi var mı kontrol edelim.
	- varsa testimiz BAŞARILI, yoksa BAŞARISIZ olsun.*/
    public GooglePage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "q")
    public WebElement aramaKutusu;

    @FindBy (tagName = "a") //Sayfadaki tum linkleri almanin kisa yolu
    public List<WebElement> linkler;
}
