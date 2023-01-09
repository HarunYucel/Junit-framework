package My_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class Test25_webtables extends TestBase {
/*
tablo
header
Header row
Header data

body
row
data
 */
/*
1."https://www.amazon.com" adresine gidin
2.Sayfanin en altina inin
3.Web table tum body’sini yazdirin
4.Web table’daki satir sayisinin 9 oldugunu test edin
5.Tum satirlari yazdirin
6. Web table’daki sutun sayisinin 13 olduğunu test edin
7. 5.sutunu yazdirin
8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
döndüren bir method olusturun
 */

    @Test
    public void Testwebtable(){

        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.CONTROL).keyDown(Keys.END)
                .keyUp(Keys.CONTROL).keyUp(Keys.END).perform();

        //3.Web table tum body’sini yazdirin
      List<WebElement> tbody = driver.findElements(By.xpath("//*[@id=\"navFooter\"]/div[4]/table/tbody"));

            String tumtablo = "";
            int sirano = 0;
        for (int i = 0; i < tbody.size() ; i++) {

          tumtablo = tbody.get(i).getText();
            sirano++;

        }

        System.out.println(tumtablo);


        //4.Web table’daki satir sayisinin 9 oldugunu test edin

     List<WebElement>satirsayisi =driver.findElements(By.xpath("//*[@id=\"navFooter\"]/div[4]/table/tbody/tr"));

       Assert.assertEquals(satirsayisi.size(),9);

       //5.Tum satirlari yazdirin

        System.out.println("==============================================================================");

        for (WebElement eachsatir:satirsayisi
             ) {

            System.out.println(eachsatir.getText());
        }


        //6. Web table’daki sutun sayisinin 13 olduğunu test edin

    List<WebElement>sutunSayisi = driver.findElements(By.xpath("//*[@id=\"navFooter\"]/div[4]/table/tbody/tr[1]/td"));

        System.out.println(sutunSayisi.size());

        //7. 5.sutunu yazdirin

        System.out.println(sutunSayisi.get(5).getText()); // hiclik olarak geliyor


        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
        //döndüren bir method olusturun


        System.out.println("==================");
        WebElement istenenDataElementi= getElement(5,7);
        System.out.println(istenenDataElementi.getText());

        ReusableMethods.bekle(5);
    }

    private WebElement getElement(int satir, int sutun) {

        //     //tbody/tr[5]/td[7]

        String dinamikXpath="//tbody/tr["+ satir +"]/td["+ sutun +"]";

        WebElement istenenElement= driver.findElement(By.xpath(dinamikXpath));


        return istenenElement;
    }

}












