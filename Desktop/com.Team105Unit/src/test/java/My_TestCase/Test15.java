package My_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class Test15 extends TestBase {

    /*
    Yeni bir class olusturalim: MouseActions3




     */



    @Test
    public void testmouse(){
     //   1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
    //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin

      WebElement Accoauntlists = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        Actions actions = new Actions(driver);

        actions.moveToElement(Accoauntlists).perform();

      String ilksayfa =  driver.getWindowHandle();

     //3- “Create a list” butonuna basin
        WebElement Createalist = driver.findElement(By.xpath("//*[text()='Create a List']"));
        actions.doubleClick(Createalist).perform();

//4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        Set<String>sayfalarhndl = driver.getWindowHandles();
        String ikincisayfa = "";
        for (String each:sayfalarhndl
             ) {
            if (!each.equals(ilksayfa)){
                ikincisayfa=each;
            }

        }

        driver.switchTo().window(ikincisayfa);

      String actualelement  = driver.findElement(By.xpath("//*[@aria-level='1']")).getText();

        Assert.assertTrue(actualelement.equals("Your Lists"));





    }


}
