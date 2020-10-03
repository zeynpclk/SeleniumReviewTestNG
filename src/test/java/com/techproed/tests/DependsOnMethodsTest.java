package com.techproed.tests;

import org.testng.annotations.Test;

public class DependsOnMethodsTest {

    @Test
    public void test01(){  // sisteme giris testi
        System.out.println("test01");
    }
    @Test (dependsOnMethods = "test01") // her seferind ilk once test01'i calistirir
    public void test02(){  // sisteme giris yaptiktan sonraki islemler
        System.out.println("test02");
    }
}
