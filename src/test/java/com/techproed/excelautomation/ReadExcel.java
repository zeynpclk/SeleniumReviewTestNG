package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {
        String dosyaAdresi = "src\\test\\resources\\ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaAdresi);// Excel dosyasini acar ancak okuyamaz
        // Excel dosyasini okumak icin Workbook kullaniyoruz
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Excel == Workbook
        //Sayfa == Sheet
        //Satir == Row
        //Hucre == Cell

        //SAYFA (sheet) SECIMI ( index 0'dan basliyor )
        Sheet sayfa1 = workbook.getSheetAt(0);

        //SATIR (row) SECIMI (index 0'dan basliyor)
        Row satir1 = workbook.getSheetAt(0).getRow(0);//Row satir1
        // Row satir1 = sayfa1.getrow(0);  ---> bu sekilkde de yazabiliriz

        //HUCRE (cell) SECIMI (index 0'dan basliyor)
        Cell satir1hucre1 = workbook.getSheetAt(0).getRow(0).getCell(0);
        // satir1.getCell(0);

        System.out.println(satir1hucre1);
        System.out.println(workbook.getSheetAt(0).getRow(2).getCell(1));

        //Tablodaki son satirin indexini aliyoruz
        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum();
        // Tum ULKELER sutununu ekrana yazdirdik
         for (int i = 0 ; i<= sonSatirinIndexi ; i++) {
             System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
         }
         // Tum baskentler sutununu ekrana yazdiralim
        for (int j = 0; j<= sonSatirinIndexi ; j++) {
            System.out.println(workbook.getSheetAt(0).getRow(j).getCell(1));

        }
        // Belirli bir satirdaki tum hucreleri yazdirma
        // son sutunun indexini aliyoruz
        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("sonSutunIndex : " + sonSutunIndex);
        for (int k = 0; k<sonSutunIndex ; k++) {
            System.out.println(workbook.getSheetAt(0).getRow(3).getCell(k));
        }


        // Excel dosyasini kapatmak icin bu kodlari kullanabiliriz.
        workbook.close();
        fileInputStream.close();

    }
}
