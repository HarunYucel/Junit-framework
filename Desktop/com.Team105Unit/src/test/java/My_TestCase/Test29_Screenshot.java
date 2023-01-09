package My_TestCase;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class Test29_Screenshot extends TestBase {
    /*
    Yeni bir class olusturun : amazonNutellaSearch
1- amazon anasayfaya gidin
2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
3- Nutella icin arama yapin
4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
     */

    @Test
    public void Screenshottest() throws IOException {
        driver.get("https://www.amazon.com/");

      Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/");

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File sayfaekrani = new File("target/ekranResimleri/sayfaEkranSS.img)");

        File gecicidosya = screenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(gecicidosya,sayfaekrani);

       WebElement arama  = driver.findElement(By.id("twotabsearchtextbox"));
       arama.sendKeys("Nutella");
        driver.findElement(By.id("nav-search-submit-button")).click();

     WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuc.getText());

        Assert.assertTrue(sonuc.getText().contains("Nutella"));

        WebElement ilkurun = driver.findElement(By.xpath("//img[@data-image-index='1']"));

        File ilkurungoruntu = new File("target/ekranResimleri/sayfailkurunEkranSS.jpeg");

        File geciciresim = ilkurun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciresim,ilkurungoruntu);




    }



}
