package My_TestCase;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class Test24_tekrar extends TestBase {

    /*
    1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin
     */


    @Test
    public void tekrartest(){

    //    1."http://webdriveruniversity.com/" adresine gidin


      driver.get("http://webdriveruniversity.com/");

    String ilksayfahdldegeri = driver.getWindowHandle();

        System.out.println(ilksayfahdldegeri);

        //2."Login Portal" a kadar asagi inin

     //3."Login Portal" a tiklayin

        Actions actions = new Actions(driver);

        WebElement loginportal = driver.findElement(By.id("login-portal"));

        actions.moveToElement(loginportal).perform();

        loginportal.click();


        //4.Diger window'a gecin


     Set<String>hendillar =driver.getWindowHandles();

   String ikincisayfahndl ="";

        for (String each:hendillar ) {
            if (!each.equals(ilksayfahdldegeri))
                ikincisayfahndl=each;

        }
        System.out.println(ikincisayfahndl);

        driver.switchTo().window(ikincisayfahndl);

       //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin

        Faker faker = new Faker();

        String pasword = faker.internet().password();
       WebElement username =  driver.findElement(By.xpath("//input[@placeholder='Username']"));

        actions.click(username).sendKeys(faker.name().firstName()).keyDown(Keys.TAB)
                .sendKeys(pasword).
                keyDown(Keys.TAB).
                keyUp(Keys.TAB);

        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();


    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin


  String actualAlert =  driver.switchTo().alert().getText();
  String expectedAlert =  "validation failed";

  Assert.assertEquals(actualAlert,expectedAlert);

  //Ok diyerek Popup'i kapatin

driver.switchTo().alert().accept();

//9.Ilk sayfaya geri donun
//10.Ilk sayfaya donuldugunu test edin

   driver.switchTo().window(ilksayfahdldegeri);
        System.out.println(driver.getTitle());



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
