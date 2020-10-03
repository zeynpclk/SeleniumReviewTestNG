package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties properties;
    static{  //static blok
        String dosyaYolu = "C:\\Users\\User\\IdeaProjects\\SeleniumReviewTestNG\\configuration.properties";
        try{
            // okumak istediğiniz dosyanın, dosya yolunu göndermemiz gerekiyor.
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (Exception e){
        }
    }
    public static String getProperty(String key){
        String deger = properties.getProperty(key);
        return deger;
    }

}
