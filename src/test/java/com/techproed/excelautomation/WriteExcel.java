package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
   public void test () throws IOException {
    String dosyaAdresi = "src\\test\\resources\\ULKELER.xlsx";
    // JAVA'da herhangi bir dosyanin acilabilmesi icin, FileInputStream
    // clas'indan bir tane nesne olusturulur ve parametre olarak,
    // acilmak istenen dosyanin adresi eklenir.
    FileInputStream fileInputStream = new FileInputStream(dosyaAdresi);
    // Excel dosyasini okumak icin Workbook kullaniyoruz.
    Workbook workbook = WorkbookFactory.create(fileInputStream);
    // Dosyaya yeni bir bilgi ekleyebilmek icin (dosya yazmak icin)
    FileOutputStream fileOutputStream = new FileOutputStream(dosyaAdresi);
    //0.indexteki satirda,3.indexte hucre olusturduk ve icerisine nufus yazdik
    workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NÜFUS");
    // 1. indexteki satirda, 3.indexte hucre olusturduk ve icerisine 83.000.000 yazdirdik.
    workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("83.000.000");

    // Istedigimiz satiri tamamiyle silmek icin bu kodu kullaniyoruz.
     Row onuncuSatir = workbook.getSheetAt(0).getRow(10);
     workbook.getSheetAt(0).removeRow(onuncuSatir);

     // Istedigimiz hucreyi silmek icin bu kodu kullaniyoruz
     Cell almanyaNüfus = workbook.getSheetAt(0).getRow(1).getCell(3);// 83.000.000
     workbook.getSheetAt(0).getRow(1).removeCell(almanyaNüfus);



    // yaptigimiz degisiklikleri excel dosyasina uygular ve kaydeder.
    workbook.write(fileOutputStream);




    fileOutputStream.close();
    workbook.close();
    fileInputStream.close();


    }
}
