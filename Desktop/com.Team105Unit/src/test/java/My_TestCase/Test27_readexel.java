package My_TestCase;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Test27_readexel {

    /*
    Yeni bir test method olusturalim readExcel2( )
- 1.satirdaki 2.hucreye gidelim ve yazdiralim
- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
- Satir sayisini bulalim
- Fiziki olarak kullanilan satir sayisini bulun
- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */



    @Test

    public void Testreadexel() throws IOException {

    // - 1.satirdaki 2.hucreye gidelim ve yazdiralim

   String dosyayolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
   FileInputStream fileInputStream = new FileInputStream(dosyayolu);
   Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("Sayfa1");

        System.out.println(sheet.getRow(0).getCell(1));

        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

      String ikincihucre =sheet.getRow(0).getCell(1).toString();
        System.out.println(ikincihucre);

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim

       String dorduncucell = sheet.getRow(1).getCell(3).toString();

        Assert.assertEquals(dorduncucell,"Kabil");

        //- Satir sayisini bulalim
        System.out.println( (sheet.getLastRowNum()+1));  // 0 dan basladıgı icin 1 fazlasını aldım

        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sheet.getPhysicalNumberOfRows());


        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim


        //  Ulke ismi ingilizce ==> key, geriye kalan 3 bilgi ise birlestirilerek value olsun
     /*   Map<String,String> ulkelerMap = new TreeMap<>();
        int sonSatirIndexi= workbook.getSheet("Sayfa1").getLastRowNum();
        String key="";
        String value="";
        for (int i = 0; i <=sonSatirIndexi ; i++) {
            key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() +", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() +", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap); */

    }

}
