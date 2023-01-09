package My_TestCase;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test26_Readexel  {

    /*
    1. apache poi dependency’i pom file’a ekleyelim
2. Java klasoru altinda resources klasoru olusturalim
3. Excel dosyamizi resources klasorune ekleyelim
4. excelAutomation isminde bir package olusturalim
5. ReadExcel isminde bir class olusturalim
6. readExcel( ) method olusturalim
7. Dosya yolunu bir String degiskene atayalim
8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
10. WorkbookFactory.create(fileInputStream)
11. Worksheet objesi olusturun workbook.getSheetAt(index)
12. Row objesi olusturun sheet.getRow(index)
13. Cell objesi olusturun row.getCell(index)
     */



    @Test
    public void readexelTest() throws IOException {

      String dosyayolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
      FileInputStream fis = new FileInputStream(dosyayolu);
     //   9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

        Workbook workbook = WorkbookFactory.create(fis);
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)

        Sheet sheet = workbook.getSheet("sayfa1");

       // 12. Row objesi olusturun sheet.getRow(index)

        Row row = sheet.getRow(1);

        // 13. Cell objesi olusturun row.getCell(index)

        Cell cell = row.getCell(2);



    }



}
