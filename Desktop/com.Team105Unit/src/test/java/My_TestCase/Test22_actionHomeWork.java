package My_TestCase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test22_actionHomeWork extends TestBase {

    /*
    1. "http://webdriveruniversity.com/Actions" sayfasina gidin
2. "Hover over Me First" kutusunun ustune gelin
3. "Link 1" e tiklayin
4. Popup mesajini yazdirin
5. Popup'i tamam diyerek kapatin
6. "Click and hold" kutusuna basili tutun
7. "Click and hold" kutusunda cikan yaziyi yazdirin
8. "Double click me" butonunu cift tiklayin
     */

 @Test
 public void Actions(){
 //  1. "http://webdriveruniversity.com/Actions" sayfasina gidin
     driver.get("http://webdriveruniversity.com/Actions");
//2. "Hover over Me First" kutusunun ustune gelin

     Actions actions = new Actions(driver);
     WebElement HoveroverMeFirst = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > button"));
    actions.moveToElement(HoveroverMeFirst).perform();

//3. "Link 1" e tiklayin

 driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();

 //4. Popup mesajini yazdirin

     System.out.println(driver.switchTo().alert().getText());

 //    5. Popup'i tamam diyerek kapatin

     driver.switchTo().alert().accept();
     driver.switchTo().defaultContent();

//6. "Click and hold" kutusuna basili tutun

     driver.findElement(By.xpath("//p[text()='Click and Hold!']")).click();

//7. "Click and hold" kutusunda cikan yaziyi yazdirin

     System.out.println(driver.findElement(By.xpath("//div[text()='Dont release me!!!']")).getText());

     WebElement doubleclicme = driver.findElement(By.xpath("//h2['Double Click Me!']"));

   //  8. "Double click me" butonunu cift tiklayin

actions.doubleClick(doubleclicme).perform();




 }

/*
doubleClick ( ): WebElement’e çift tıklama yapar
clickAndHold ( ) : WebElement uzerinde click yapili
olarak bizden komut bekler.
dragAndDrop ( ): WebElement’i bir noktadan diğerine
sürükler ve bırakır
moveToElement ( ): Mouse’u istedigimiz
WebElement’in uzerinde tutar
contextClick ( ): Mouse ile istedigimiz WebElement’e sag tiklama yapar.
 */



}
