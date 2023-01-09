package My_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Test19_fileupload extends TestBase {

    /*
    1. Tests packagenin altina bir class oluşturun : C05_UploadFile
2. https://the-internet.herokuapp.com/upload adresine gidelim
3. chooseFile butonuna basalim
4. Yuklemek istediginiz dosyayi secelim.
5. Upload butonuna basalim.
6. “File Uploaded!” textinin goruntulendigini test edelim.
     */


    @Test
    public void Fileupload(){
   driver.get("https://the-internet.herokuapp.com/upload");
  String dosyayolu = System.getProperty("user.home")+"\\Downloads\\LambdaTest.txt";

WebElement dosyasec = driver.findElement(By.xpath("//input[@name='file']"));

dosyasec.sendKeys(dosyayolu);

driver.findElement(By.xpath("//input[@value='Upload']")).click();
Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());


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




}
