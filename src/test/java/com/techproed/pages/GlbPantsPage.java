package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbPantsPage {

    // constructor olusturmak zorundayiz
    //PageFactory.initElements(){} bu methodu kullanmak zorundayiz.
    //Bu methodu kullanmazsak webelement arama islemini yapamayiz

    public GlbPantsPage(){ // driver static oldugu icin parametre olarak yazmak zorunda degiliz
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy ( xpath = "//p[@class='cat_bg_top']") // ilk webElement'in xpath'ini aldik
    public List<WebElement> basliklar; // Bu sekilde tum elementleri alabiliriz
}
