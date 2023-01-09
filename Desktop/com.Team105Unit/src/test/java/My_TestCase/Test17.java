package My_TestCase;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test17 extends TestBase {

    /*



4- Kaydol tusuna basalim
     */


    @Test
    public void Facebookt(){
    //  1- https://www.facebook.com adresine gidelim
    driver.get("https://www.facebook.com");

    //2- Yeni hesap olustur butonuna basalim

        Actions actions = new Actions(driver);

        actions
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.ENTER).perform();

     //   3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement fistnamekutuE = driver.findElement(By.tagName("firstname"));

        Faker faker = new Faker();
        actions.clickAndHold(fistnamekutuE).sendKeys(faker.name().firstName())
                .keyDown(Keys.TAB).sendKeys(faker.name().lastName()).keyDown(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).keyDown(Keys.TAB)
                .sendKeys(faker.internet().password()).keyDown(Keys.TAB)
                .keyDown(Keys.TAB).sendKeys("01").keyDown(Keys.TAB)
                .sendKeys("02").keyDown(Keys.TAB).sendKeys("Oca").keyDown(Keys.TAB)
                .sendKeys("1990").keyDown(Keys.TAB);


    }

}
