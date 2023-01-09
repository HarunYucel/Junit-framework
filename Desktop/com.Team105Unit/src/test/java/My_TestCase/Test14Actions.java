package My_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class Test14Actions extends TestBase {



    @Test
    public  void TestAction(){
  // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin

    driver.get("https://the-internet.herokuapp.com/context_menu");
 //3- Cizili alan uzerinde sag click yapin

   WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));

        Actions action = new Actions(driver);

        action.contextClick(ciziliAlan).perform();

  //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
      String actualAlert = driver.switchTo().alert().getText();
      String expectedAlert = "You selected a context menu";
        Assert.assertEquals(actualAlert,expectedAlert);

     //   5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

       // 6- Elemental Selenium linkine tiklayalim

        driver.switchTo().defaultContent();
       String ilksayfahndl = driver.getWindowHandle();

        driver.findElement(By.linkText("Elemental Selenium")).click();

       //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String>hdls = driver.getWindowHandles();
        String ikincisayfahdl="";
        for (String each:hdls
             ) {
            if (!each.equals(ilksayfahndl)){
                ikincisayfahdl=each;
            }
        }

        driver.switchTo().window(ikincisayfahdl);

      String actualtext= driver.findElement(By.tagName("h1")).getText();
      String expectedtext= "Elemental Selenium";

Assert.assertEquals(actualtext,expectedtext);





    }




}
