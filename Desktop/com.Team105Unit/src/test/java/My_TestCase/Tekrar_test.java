package My_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Tekrar_test extends TestBase {

    /*
    1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
2. “Our Products” butonuna basin
3. “Cameras product”i tiklayin
4. Popup mesajini yazdirin
5. “close” butonuna basin
6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
     */

    @Test

    public void testtekrar(){
    //  1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    driver.get("http://webdriveruniversity.com/IFrame/index.html");

   //  “Our Products” butonuna basin

    driver.findElement(By.xpath("/html/body/div[1]/div/div/nav/div/ul/li[2]/a")).click();


    //3. “Cameras product”i tiklayin

  driver.findElement(By.xpath("//img[@id='camera-img']")).click();

    //4. Popup mesajini yazdirin

    System.out.println(driver.switchTo().alert().getText());

      //  5. “close” butonuna basin
    driver.switchTo().alert().accept();


   //     6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        WebElement iframeelementi= driver.findElement(By.xpath("//a[text()='WebdriverUniversity.com (IFrame)']"));

        driver.switchTo().frame(iframeelementi);

        iframeelementi.click();

        driver.switchTo().defaultContent();

      //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualurl= driver.getCurrentUrl();
        String expectedurl= "http://webdriveruniversity.com/index.html";

        Assert.assertEquals(actualurl,expectedurl);


    }






}
