package My_TestCase;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test31_geneltekrar extends TestBase {
    /*
    1. "https://facebook.com" Adresine gidin
2. “create new account” butonuna basin
3. “firstName” giris kutusuna bir isim yazin
4. “surname” giris kutusuna bir soyisim yazin
5. “email” giris kutusuna bir email yazin
6. “email” onay kutusuna emaili tekrar yazin
7. Bir sifre girin
8. Tarih icin gun secin
9. Tarih icin ay secin
10. Tarih icin yil secin
11. Cinsiyeti secin
12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13. Sayfayi kapatin
     */


    @Test
    public void Testtekrar() {

        driver.get("https://facebook.com");
        //  2. “create new account” butonuna basin

      //  actions.keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.TAB).keyUp(Keys.TAB).perform();


         driver.findElement(By.id("u_0_0_9A")).click();


       /* actions.keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.TAB).
                keyUp(Keys.TAB).perform();
     actions.doubleClick().perform();*/
//3. “firstName” giris kutusuna bir isim yazin

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        actions.sendKeys(faker.name().firstName()).keyDown(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(faker.internet().emailAddress()).keyDown(Keys.TAB)
                .sendKeys(faker.internet().password()).keyDown(Keys.TAB).sendKeys("5").keyDown(Keys.TAB)
                .sendKeys("Ocak").keyDown(Keys.TAB).sendKeys("2020").keyDown(Keys.TAB)
                .keyDown(Keys.TAB).click().keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.TAB)
                .keyDown(Keys.TAB).keyDown(Keys.TAB).keyUp(Keys.TAB).doubleClick().perform();




    }

}
